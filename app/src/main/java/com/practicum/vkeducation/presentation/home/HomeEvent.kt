package com.practicum.vkeducation.presentation.home

sealed interface HomeEvent {
    data object OnLogoClick : HomeEvent
}