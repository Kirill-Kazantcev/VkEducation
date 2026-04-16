package com.practicum.vkeducation.data.repository

import com.practicum.vkeducation.data.api.AppApi
import com.practicum.vkeducation.data.dto.ShortAppDetailsDto
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeRepositoryImplTest {

    private lateinit var api: AppApi
    private lateinit var repository: HomeRepositoryImpl

    @Before
    fun setUp() {
        api = mockk()
        repository = HomeRepositoryImpl(api)
    }

    @Test
    fun `getAllShortAppDetails should return list when api returns data`() = runTest {
        val mockDtoList = listOf(
            ShortAppDetailsDto(id = "1", name = "App 1", category = "Игры", iconUrl = "icon1.png", shortDescription = "Desc1"),
            ShortAppDetailsDto(id = "2", name = "App 2", category = "Финансы", iconUrl = "icon2.png", shortDescription = "Desc2")
        )
        coEvery { api.getAppsList() } returns mockDtoList

        val result = repository.getAllShortAppDetails()

        assertEquals(2, result.size)
        assertEquals("1", result[0].id)
        coVerify(exactly = 1) { api.getAppsList() }
    }

    @Test
    fun `getAllShortAppDetails should return empty list when api returns empty`() = runTest {
        coEvery { api.getAppsList() } returns emptyList()

        val result = repository.getAllShortAppDetails()

        assertTrue(result.isEmpty())
        coVerify(exactly = 1) { api.getAppsList() }
    }

    @Test
    fun `getAllShortAppDetails should return mock data when api throws exception`() = runTest {
        coEvery { api.getAppsList() } throws RuntimeException("Network error")

        val result = repository.getAllShortAppDetails()

        assertTrue(result.isNotEmpty())
        assertEquals("1", result[0].id)
    }

    @Test
    fun `getAllShortAppDetails should correctly map DTO to domain`() = runTest {
        val expectedDto = ShortAppDetailsDto(
            id = "42",
            name = "Mapped App",
            category = "Образование",
            iconUrl = "map.png",
            shortDescription = "Mapped desc"
        )
        coEvery { api.getAppsList() } returns listOf(expectedDto)

        val result = repository.getAllShortAppDetails()

        assertEquals("42", result[0].id)
        assertEquals("Mapped App", result[0].name)
        assertEquals("map.png", result[0].iconUrl)
    }

    @Test
    fun `getAllShortAppDetails should call api multiple times`() = runTest {
        val mockDtoList = listOf(ShortAppDetailsDto(id = "1", name = "App", category = "Игры", iconUrl = "icon.png", shortDescription = "Desc"))
        coEvery { api.getAppsList() } returns mockDtoList

        repeat(3) { repository.getAllShortAppDetails() }

        coVerify(exactly = 3) { api.getAppsList() }
    }
}