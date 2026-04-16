package com.practicum.vkeducation.data.repository

import com.practicum.vkeducation.data.api.AppApi
import com.practicum.vkeducation.data.local.AppDetailsDao
import com.practicum.vkeducation.data.local.AppDetailsEntityMapper
import com.practicum.vkeducation.data.mock.AppDetailsMockApi
import com.practicum.vkeducation.data.mapper.toDomain
import com.practicum.vkeducation.domain.appdetails.AppDetails
import com.practicum.vkeducation.domain.repository.AppDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val appApi: AppApi,
    private val dao: AppDetailsDao,
    private val entityMapper: AppDetailsEntityMapper
) : AppDetailsRepository {

    override suspend fun getAppDetails(id: String): AppDetails {
        return withContext(Dispatchers.IO) {
            val entity = dao.getAppDetails(id)
            if (entity != null) {
                return@withContext entityMapper.toDomain(entity)
            }

            try {
                val dto = appApi.getAppDetails(id)
                val domain = dto.toDomain()
                dao.insertAppDetails(entityMapper.toEntity(domain))
                return@withContext domain
            } catch (e: Exception) {
                val mockDto = AppDetailsMockApi.getAppDetails().copy(id = id)
                val domain = mockDto.toDomain()
                dao.insertAppDetails(entityMapper.toEntity(domain))
                return@withContext domain
            }
        }
    }
}