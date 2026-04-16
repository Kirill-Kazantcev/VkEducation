package com.practicum.vkeducation.domain.repository

import com.practicum.vkeducation.domain.appdetails.AppDetails
import kotlinx.coroutines.flow.Flow

interface AppDetailsRepository {
    suspend fun getAppDetails(id: String): AppDetails
    suspend fun toggleWishlist(id: String)
    fun observeAppDetails(id: String): Flow<AppDetails>
}