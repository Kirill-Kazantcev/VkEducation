package com.practicum.vkeducation.data.repository

import com.practicum.vkeducation.data.api.AppApi
import com.practicum.vkeducation.data.mapper.toDomain
import com.practicum.vkeducation.domain.appdetails.AppDetails
import com.practicum.vkeducation.domain.repository.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val appApi: AppApi
) : AppDetailsRepository {
    override suspend fun getAppDetails(id: String): AppDetails {
        val dto = appApi.getAppDetails(id)
        return dto.toDomain()
    }
}