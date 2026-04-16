package com.practicum.vkeducation.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {
    @Serializable
    data object HOME : Routes()

    @Serializable
    data class APP_DETAILS(val id: String) : Routes()
}