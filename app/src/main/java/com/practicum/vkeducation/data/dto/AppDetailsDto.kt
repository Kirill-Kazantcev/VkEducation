package com.practicum.vkeducation.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppDetailsDto(
    val id: String,
    val name: String,
    val developer: String,
    val category: String,
    @SerialName("ageRating") val ageRating: Int,
    @SerialName("size") val size: Float,
    @SerialName("iconUrl") val iconUrl: String,
    @SerialName("screenshotUrlList") val screenshotUrlList: List<String>?,
    @SerialName("description") val description: String,
)