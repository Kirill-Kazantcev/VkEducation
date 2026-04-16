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
        val entity = dao.getAppDetails(id)
        return if (entity != null) {
            entityMapper.toDomain(entity)
        } else {
            try {
                val dto = appApi.getAppDetails(id)
                val domain = dto.toDomain()
                withContext(Dispatchers.IO) {
                    dao.insertAppDetails(entityMapper.toEntity(domain))
                }
                domain
            } catch (e: Exception) {
                val mockDto = AppDetailsMockApi.getAppDetails().copy(id = id)
                mockDto.toDomain()
            }
        }
    }
}