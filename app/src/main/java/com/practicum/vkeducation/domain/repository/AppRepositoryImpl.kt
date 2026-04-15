package com.practicum.vkeducation.domain.repository

import com.practicum.vkeducation.domain.appdetails.AppDetails

interface AppDetailsRepository {
    suspend fun getAppDetails(): AppDetails
}