package com.practicum.vkeducation.domain.repository

import com.practicum.vkeducation.domain.home.ShortAppDetails

interface HomeRepository {
    suspend fun getShortAppDetails(): List<ShortAppDetails>
}