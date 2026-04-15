package com.practicum.vkeducation.data.mapper

import com.practicum.vkeducation.domain.appdetails.Category

fun mapStringToCategory(categoryString: String): Category {
    return when (categoryString) {
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
}