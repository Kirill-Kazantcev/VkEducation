package com.practicum.vkeducation.data.repository

import com.practicum.vkeducation.data.api.AppApi
import com.practicum.vkeducation.data.mock.HomeMockApi
import com.practicum.vkeducation.data.mapper.toDomain
import com.practicum.vkeducation.domain.home.ShortAppDetails
import com.practicum.vkeducation.domain.repository.HomeRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val appApi: AppApi
) : HomeRepository {
    override suspend fun getAllShortAppDetails(): List<ShortAppDetails> {
        return try {
            val dtoList = appApi.getAppsList()
            dtoList.map { it.toDomain() }
        } catch (e: Exception) {
            e.printStackTrace()
            delay(1000)
            HomeMockApi.getShortAppDetailsList().map { it.toDomain() }
        }
    }
}