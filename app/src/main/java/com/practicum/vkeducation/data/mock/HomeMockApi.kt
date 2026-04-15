package com.practicum.vkeducation.data.mock

import com.practicum.vkeducation.data.dto.ShortAppDetailsDto

object HomeMockApi {
    fun getShortAppDetailsList(): List<ShortAppDetailsDto> {
        return listOf(
            ShortAppDetailsDto(
                id = "1",
                name = "СберБанк Онлайн",
                category = "Финансы",
                iconUrl = "https://static.rustore.ru/imgproxy/lQKIdJKRbtJBX0dxbZueqU-a5TEP_-_yKjFjWljOsaE/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp",
                shortDescription = "Больше чем банк",
            ),
            ShortAppDetailsDto(
                id = "2",
                name = "Яндекс.Браузер — с Алисой AI",
                category = "Инструменты",
                iconUrl = "https://static.rustore.ru/imgproxy/rGr87NnjSOsiX-imht9uyNnHK-YDQJNvIlY2rIb4gsA/preset:web_app_icon_62/plain/https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png@webp",
                shortDescription = "Быстрый и безопасный браузер",
            ),
            ShortAppDetailsDto(
                id = "3",
                name = "Mail: Почта, Облако, Календарь",
                category = "Инструменты",
                iconUrl = "https://static.rustore.ru/imgproxy/PwdwPJeeTFjJa8qBiPIwerw43wiL94clWY4A_4oxt48/preset:web_app_icon_62/plain/https://static.rustore.ru/2026/3/11/7c/apk/332223/content/ICON/2ea61211-2ee2-469b-a08e-acc8a9f3b4c6.png@webp",
                shortDescription = "Почтовый клиент для любых ящиков",
            ),
            ShortAppDetailsDto(
                id = "4",
                name = "Яндекс Навигатор",
                category = "Карты",
                iconUrl = "https://static.rustore.ru/imgproxy/P0Em8fwcZIhhOo3WQzCBmTlyT2Q9Xw1FJtx0nEwuEoU/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/595135/content/ICON/32cb5e63-9c59-4280-9a6a-c808113be88f.png@webp",
                shortDescription = "Парковки и заправки – по пути",
            ),
            ShortAppDetailsDto(
                id = "5",
                name = "Мой МТС",
                category = "Инструменты",
                iconUrl = "https://static.rustore.ru/imgproxy/ycc_vNBYtD70IPhATGiRARVzqBTQHzHlJK5fgR6DCPQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/336831/content/ICON/ea6c9e63-bd7f-486f-ac3f-3e9069ecf018.png@webp",
                shortDescription = "Мой МТС — центр экосистемы МТС",
            ),
            ShortAppDetailsDto(
                id = "6",
                name = "Яндекс — с Алисой AI",
                category = "Инструменты",
                iconUrl = "https://static.rustore.ru/imgproxy/1A_F3rBwWHQ5Z_aZcwxyI24YceoUAqpCKqSn5gWtlqo/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/313257919/content/ICON/843c5040-0e09-41bb-958c-b7bacc912c2b.png@webp",
                shortDescription = "Яндекс — поиск всегда под рукой",
            )
        )
    }
}