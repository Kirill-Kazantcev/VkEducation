package com.practicum.vkeducation.domain.home

import com.practicum.vkeducation.domain.appdetails.Category

data class ShortAppDetails(
    val id: String,
    val name: String,
    val category: Category,
    val iconUrl: String,
    val shortDescription: String,
)