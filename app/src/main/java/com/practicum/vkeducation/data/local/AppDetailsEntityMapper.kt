package com.practicum.vkeducation.data.local

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.practicum.vkeducation.domain.appdetails.AppDetails

class AppDetailsEntityMapper {
    private val gson = Gson()
    private val listType = object : TypeToken<List<String>>() {}.type

    fun toEntity(domain: AppDetails): AppDetailsEntity {
        return AppDetailsEntity(
            id = domain.id,
            name = domain.name,
            developer = domain.developer,
            category = domain.category,
            ageRating = domain.ageRating,
            size = domain.size,
            iconUrl = domain.iconUrl,
            screenshots = domain.screenshotUrlList?.let { gson.toJson(it) },
            description = domain.description,
            isInWishlist = domain.isInWishlist
        )
    }

    fun toDomain(entity: AppDetailsEntity): AppDetails {
        return AppDetails(
            id = entity.id,
            name = entity.name,
            developer = entity.developer,
            category = entity.category,
            ageRating = entity.ageRating,
            size = entity.size,
            iconUrl = entity.iconUrl,
            screenshotUrlList = entity.screenshots?.let { gson.fromJson(it, listType) },
            description = entity.description,
            isInWishlist = entity.isInWishlist
        )
    }
}