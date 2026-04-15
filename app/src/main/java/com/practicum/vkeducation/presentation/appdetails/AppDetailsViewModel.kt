package com.practicum.vkeducation.presentation.appdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicum.vkeducation.data.repository.AppDetailsRepositoryImpl
import com.practicum.vkeducation.domain.repository.AppDetailsRepository
import com.practicum.vkeducation.domain.usecase.GetAppDetailsUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppDetailsViewModel : ViewModel() {

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    private val repository: AppDetailsRepository = AppDetailsRepositoryImpl()
    private val getAppDetailsUseCase = GetAppDetailsUseCase(repository)

    init {
        getAppDetails()
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
        viewModelScope.launch {
            _state.value = AppDetailsState.Loading
            runCatching {
                getAppDetailsUseCase()
            }.onSuccess { appDetails ->
                _state.value = AppDetailsState.Content(
                    appDetails = appDetails,
                    descriptionCollapsed = false,
                )
            }.onFailure {
                _state.value = AppDetailsState.Error
            }
        }
    }
}