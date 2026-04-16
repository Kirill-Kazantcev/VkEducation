package com.practicum.vkeducation.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicum.vkeducation.domain.usecase.GetAllShortAppDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllShortAppDetailsUseCase: GetAllShortAppDetailsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<HomeState>(HomeState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<HomeEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        getShortAppDetails()
    }

    fun showOnLogoClickMessage() {
        viewModelScope.launch {
            _events.send(HomeEvent.OnLogoClick)
        }
    }

    fun getShortAppDetails() {
        viewModelScope.launch {
            _state.value = HomeState.Loading
            runCatching {
                getAllShortAppDetailsUseCase()
            }.onSuccess { apps ->
                _state.value = HomeState.Content(appDetails = apps)
            }.onFailure {
                _state.value = HomeState.Error
            }
        }
    }
}