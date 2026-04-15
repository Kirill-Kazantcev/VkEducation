package com.practicum.vkeducation.data.repository

import com.practicum.vkeducation.data.api.AppApi
import com.practicum.vkeducation.data.mapper.toDomain
import com.practicum.vkeducation.domain.home.ShortAppDetails
import com.practicum.vkeducation.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val appApi: AppApi
) : HomeRepository {
    override suspend fun getAllShortAppDetails(): List<ShortAppDetails> {
        val dtoList = appApi.getAppsList()
        return dtoList.map { it.toDomain() }
    }
}