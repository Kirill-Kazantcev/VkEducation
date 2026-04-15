package com.practicum.vkeducation.presentation.home

import com.practicum.vkeducation.domain.appdetails.Category
import com.practicum.vkeducation.domain.home.ShortAppDetails

object HomeData {
    val previewApps = listOf(
        ShortAppDetails(
            name = "СберБанк Онлайн",
            category = Category.FINANCE,
            iconUrl = "https://static.rustore.ru/imgproxy/lQKIdJKRbtJBX0dxbZueqU-a5TEP_-_yKjFjWljOsaE/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp",
            shortDescription = "Больше чем банк",
        ),
        ShortAppDetails(
            name = "Яндекс.Браузер",
            category = Category.UTILITIES,
            iconUrl = "https://static.rustore.ru/imgproxy/rGr87NnjSOsiX-imht9uyNnHK-YDQJNvIlY2rIb4gsA/preset:web_app_icon_62/plain/https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png@webp",
            shortDescription = "Быстрый и безопасный браузер",
        )
    )
}