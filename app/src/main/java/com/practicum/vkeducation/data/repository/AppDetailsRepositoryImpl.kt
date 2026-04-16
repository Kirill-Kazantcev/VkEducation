package com.practicum.vkeducation.data.repository

import com.practicum.vkeducation.data.api.AppApi
import com.practicum.vkeducation.data.mock.AppDetailsMockApi
import com.practicum.vkeducation.data.mapper.toDomain
import com.practicum.vkeducation.domain.appdetails.AppDetails
import com.practicum.vkeducation.domain.repository.AppDetailsRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val appApi: AppApi
) : AppDetailsRepository {

    override suspend fun getAppDetails(id: String): AppDetails {
        return try {
            val dto = appApi.getAppDetails(id)
            dto.toDomain()
        } catch (e: Exception) {
            e.printStackTrace()
            delay(500)
            val mockDto = AppDetailsMockApi.getAppDetails().copy(id = id)
            mockDto.toDomain()
        }
    }
}