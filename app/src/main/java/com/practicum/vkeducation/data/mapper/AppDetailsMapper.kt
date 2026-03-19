package com.practicum.vkeducation.data.mapper

import com.practicum.vkeducation.data.dto.AppDetailsDto
import com.practicum.vkeducation.domain.appdetails.AppDetails
import com.practicum.vkeducation.domain.appdetails.Category

fun AppDetailsDto.toDomain(): AppDetails {

    val category = when (this.category) {
        "Приложения" -> Category.APP
        "Игры" -> Category.GAME
        "Производительность" -> Category.PRODUCTIVITY
        "Социальные сети" -> Category.SOCIAL
        "Образование" -> Category.EDUCATION
        "Развлечения" -> Category.ENTERTAINMENT
        "Музыка" -> Category.MUSIC
        "Видео" -> Category.VIDEO
        "Фотография" -> Category.PHOTOGRAPHY
        "Здоровье" -> Category.HEALTH
        "Спорт" -> Category.SPORTS
        "Новости" -> Category.NEWS
        "Книги" -> Category.BOOKS
        "Бизнес" -> Category.BUSINESS
        "Финансы" -> Category.FINANCE
        "Путешествия" -> Category.TRAVEL
        "Карты" -> Category.MAPS
        "Еда" -> Category.FOOD
        "Покупки" -> Category.SHOPPING
        "Инструменты" -> Category.UTILITIES
        else -> Category.UTILITIES
    }

    return AppDetails(
        id = this.id,
        name = this.name,
        developer = this.developer,
        category = category,
        ageRating = this.ageRating,
        size = this.size,
        iconUrl = this.iconUrl,
        screenshotUrlList = this.screenshotUrlList,
        description = this.description
    )
}