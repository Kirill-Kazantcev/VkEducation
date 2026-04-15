package com.practicum.vkeducation.presentation.home

import androidx.compose.runtime.Immutable
import com.practicum.vkeducation.domain.home.ShortAppDetails

@Immutable
sealed interface HomeState {
    data object Error : HomeState
    data object Loading : HomeState
    data class Content(
        val appDetails: List<ShortAppDetails>,
    ) : HomeState
}