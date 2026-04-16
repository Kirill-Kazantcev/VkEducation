package com.practicum.vkeducation.data.mapper

import com.practicum.vkeducation.data.dto.ShortAppDetailsDto
import com.practicum.vkeducation.domain.home.ShortAppDetails

fun ShortAppDetailsDto.toDomain(): ShortAppDetails {
    return ShortAppDetails(
        id = this.id,
        name = this.name,
        category = mapStringToCategory(this.category),
        iconUrl = this.iconUrl,
        shortDescription = this.shortDescription
    )
}