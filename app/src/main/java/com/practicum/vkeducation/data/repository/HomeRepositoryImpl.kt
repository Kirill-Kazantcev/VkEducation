package com.practicum.vkeducation.data.repository

import com.practicum.vkeducation.data.mock.HomeMockApi
import com.practicum.vkeducation.data.mapper.toDomain
import com.practicum.vkeducation.domain.home.ShortAppDetails
import com.practicum.vkeducation.domain.repository.HomeRepository
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

class HomeRepositoryImpl @Inject constructor() : HomeRepository {
    override suspend fun getAllShortAppDetails(): List<ShortAppDetails> {
        delay(1.seconds)
        val dtoList = HomeMockApi.getShortAppDetailsList()
        return dtoList.map { it.toDomain() }
    }
}