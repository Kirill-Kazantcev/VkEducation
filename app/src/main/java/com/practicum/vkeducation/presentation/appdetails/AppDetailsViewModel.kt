package com.practicum.vkeducation.presentation.appdetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicum.vkeducation.domain.repository.AppDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "AppDetailsVM"

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val repository: AppDetailsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    private val appId: String = savedStateHandle["id"] ?: ""

    init {
        loadAppDetails()
        observeAppDetails()
    }

    private fun loadAppDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                repository.getAppDetails(appId)
            }.onSuccess { appDetails ->
                _state.value = AppDetailsState.Content(
                    appDetails = appDetails,
                    descriptionCollapsed = false,
                )
            }.onFailure { error ->
                Log.e(TAG, "Ошибка загрузки", error)
                _state.value = AppDetailsState.Error
            }
        }
    }

    fun toggleWishlist() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.toggleWishlist(appId)
        }
    }

    private fun observeAppDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.observeAppDetails(appId)
                .catch { error ->
                    Log.e(TAG, "Ошибка в Flow", error)
                }
                .collect { appDetails ->
                    _state.update { currentState ->
                        if (currentState is AppDetailsState.Content) {
                            AppDetailsState.Content(
                                appDetails = appDetails,
                                descriptionCollapsed = currentState.descriptionCollapsed
                            )
                        } else {
                            AppDetailsState.Content(
                                appDetails = appDetails,
                                descriptionCollapsed = false
                            )
                        }
                    }
                }
        }
    }

    fun showUnderDevelopmentMessage() {
        viewModelScope.launch {
            _events.send(AppDetailsEvent.UnderDevelopment)
        }
    }

    fun collapseDescription() {
        _state.update { currentState ->
            if (currentState is AppDetailsState.Content) {
                currentState.copy(descriptionCollapsed = true)
            } else {
                currentState
            }
        }
    }

    fun getAppDetails() {
        loadAppDetails()
    }
}