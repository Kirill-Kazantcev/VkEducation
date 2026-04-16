package com.practicum.vkeducation.data.local

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.practicum.vkeducation.domain.appdetails.AppDetails

class AppDetailsEntityMapper {
    private val gson = Gson()

    fun toEntity(domain: AppDetails): AppDetailsEntity {
        val screenshotsJson = domain.screenshotUrlList?.let { gson.toJson(it) }
        return AppDetailsEntity(
            id = domain.id,
            name = domain.name,
            developer = domain.developer,
            category = domain.category,
            ageRating = domain.ageRating,
            size = domain.size,
            iconUrl = domain.iconUrl,
            screenshots = screenshotsJson,
            description = domain.description
        )
    }

    fun toDomain(entity: AppDetailsEntity): AppDetails {
        val screenshotUrlList = entity.screenshots?.let {
            val type = object : TypeToken<List<String>>() {}.type
            gson.fromJson(it, type)
        }
        return AppDetails(
            id = entity.id,
            name = entity.name,
            developer = entity.developer,
            category = entity.category,
            ageRating = entity.ageRating,
            size = entity.size,
            iconUrl = entity.iconUrl,
            screenshotUrlList = screenshotUrlList,
            description = entity.description
        )
    }
}