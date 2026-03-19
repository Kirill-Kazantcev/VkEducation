package com.practicum.vkeducation.data.mapper

import com.practicum.vkeducation.data.dto.ShortAppDetailsDto
import com.practicum.vkeducation.domain.appdetails.Category
import com.practicum.vkeducation.domain.home.ShortAppDetails

fun ShortAppDetailsDto.toDomain(): ShortAppDetails {
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

    return ShortAppDetails(
        name = this.name,
        category = category,
        iconUrl = this.iconUrl,
        shortDescription = this.shortDescription
    )
}