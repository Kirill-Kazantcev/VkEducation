package com.practicum.vkeducation.data.mapper

import com.practicum.vkeducation.data.dto.AppDetailsDto
import com.practicum.vkeducation.domain.appdetails.AppDetails

fun AppDetailsDto.toDomain(): AppDetails {
    return AppDetails(
        id = this.id,
        name = this.name,
        developer = this.developer,
        category = mapStringToCategory(this.category),
        ageRating = this.ageRating,
        size = this.size,
        iconUrl = this.iconUrl,
        screenshotUrlList = this.screenshotUrlList,
        description = this.description
    )
}