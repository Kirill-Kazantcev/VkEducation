package com.practicum.vkeducation.data.api

import com.practicum.vkeducation.data.dto.AppDetailsDto
import com.practicum.vkeducation.data.dto.ShortAppDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AppApi {
    @GET("catalog")
    suspend fun getAppsList(): List<ShortAppDetailsDto>

    @GET("catalog/{id}")
    suspend fun getAppDetails(@Path("id") id: String): AppDetailsDto
}