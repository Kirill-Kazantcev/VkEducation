package com.practicum.vkeducation.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicum.vkeducation.domain.appdetails.Category
import com.practicum.vkeducation.domain.home.ShortAppDetails
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class HomeViewModel : ViewModel() {

    private val _state = MutableStateFlow<HomeState>(HomeState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<HomeEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        getShortAppDetails()
    }

    fun showOnLogoClickMessage() {
        viewModelScope.launch {
            _events.send(HomeEvent.OnLogoClick)
        }
    }

    fun getShortAppDetails() {
        viewModelScope.launch {
            _state.value = HomeState.Loading

            runCatching {
                delay(1.seconds)

                val appDetails = listOf(
                    ShortAppDetails(
                        name = "СберБанк Онлайн",
                        category = Category.FINANCE,
                        iconUrl = "https://static.rustore.ru/imgproxy/lQKIdJKRbtJBX0dxbZueqU-a5TEP_-_yKjFjWljOsaE/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp",
                        shortDescription = "Больше чем банк",
                    ),
                    ShortAppDetails(
                        name = "Яндекс.Браузер — с Алисой AI",
                        category = Category.UTILITIES,
                        iconUrl = "https://static.rustore.ru/imgproxy/rGr87NnjSOsiX-imht9uyNnHK-YDQJNvIlY2rIb4gsA/preset:web_app_icon_62/plain/https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png@webp",
                        shortDescription = "Быстрый и безопасный браузер",
                    ),
                    ShortAppDetails(
                        name = "Mail: Почта, Облако, Календарь",
                        category = Category.UTILITIES,
                        iconUrl = "https://static.rustore.ru/imgproxy/PwdwPJeeTFjJa8qBiPIwerw43wiL94clWY4A_4oxt48/preset:web_app_icon_62/plain/https://static.rustore.ru/2026/3/11/7c/apk/332223/content/ICON/2ea61211-2ee2-469b-a08e-acc8a9f3b4c6.png@webp",
                        shortDescription = "Почтовый клиент для любых ящиков",
                    ),
                    ShortAppDetails(
                        name = "Яндекс Навигатор",
                        category = Category.MAPS,
                        iconUrl = "https://static.rustore.ru/imgproxy/P0Em8fwcZIhhOo3WQzCBmTlyT2Q9Xw1FJtx0nEwuEoU/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/595135/content/ICON/32cb5e63-9c59-4280-9a6a-c808113be88f.png@webp",
                        shortDescription = "Парковки и заправки – по пути",
                    ),
                    ShortAppDetails(
                        name = "Мой МТС",
                        category = Category.UTILITIES,
                        iconUrl = "https://static.rustore.ru/imgproxy/ycc_vNBYtD70IPhATGiRARVzqBTQHzHlJK5fgR6DCPQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/336831/content/ICON/ea6c9e63-bd7f-486f-ac3f-3e9069ecf018.png@webp",
                        shortDescription = "Мой МТС — центр экосистемы МТС",
                    ),
                    ShortAppDetails(
                        name = "Яндекс — с Алисой AI",
                        category = Category.UTILITIES,
                        iconUrl = "https://static.rustore.ru/imgproxy/1A_F3rBwWHQ5Z_aZcwxyI24YceoUAqpCKqSn5gWtlqo/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/313257919/content/ICON/843c5040-0e09-41bb-958c-b7bacc912c2b.png@webp",
                        shortDescription = "Яндекс — поиск всегда под рукой",
                    )
                )

                _state.value = HomeState.Content(appDetails = appDetails)
            }.onFailure {
                _state.value = HomeState.Error
            }
        }
    }
}