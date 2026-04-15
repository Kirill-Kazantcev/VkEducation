package com.practicum.vkeducation.data.repository

import com.practicum.vkeducation.data.mock.AppDetailsMockApi
import com.practicum.vkeducation.data.mapper.toDomain
import com.practicum.vkeducation.domain.appdetails.AppDetails
import com.practicum.vkeducation.domain.repository.AppDetailsRepository
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

class AppDetailsRepositoryImpl @Inject constructor() : AppDetailsRepository {
    override suspend fun getAppDetails(): AppDetails {
        delay(2.seconds)
        val dto = AppDetailsMockApi.getAppDetails()
        return dto.toDomain()
    }
}