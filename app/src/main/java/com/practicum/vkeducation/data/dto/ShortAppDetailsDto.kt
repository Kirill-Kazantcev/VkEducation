package com.practicum.vkeducation.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ShortAppDetailsDto(
    val id: String,
    val name: String,
    val category: String,
    val iconUrl: String,
    val shortDescription: String,
)