package com.practicum.vkeducation.domain.usecase

import com.practicum.vkeducation.domain.home.ShortAppDetails
import com.practicum.vkeducation.domain.repository.HomeRepository
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
class GetAllShortAppDetailsUseCaseTest {

    private lateinit var repository: HomeRepository
    private lateinit var useCase: GetAllShortAppDetailsUseCase

    @Before
    fun setUp() {
        repository = mockk()
        useCase = GetAllShortAppDetailsUseCase(repository)
    }

    @Test
    fun `invoke should return list when repository returns data`() = runTest {
        val mockList = listOf(
            ShortAppDetails(id = "1", name = "App 1", category = com.practicum.vkeducation.domain.appdetails.Category.GAME, iconUrl = "icon.png", shortDescription = "Desc"),
            ShortAppDetails(id = "2", name = "App 2", category = com.practicum.vkeducation.domain.appdetails.Category.FINANCE, iconUrl = "icon2.png", shortDescription = "Desc2")
        )
        coEvery { repository.getAllShortAppDetails() } returns mockList

        val result = useCase.invoke()

        assertEquals(2, result.size)
        assertEquals("1", result[0].id)
        coVerify(exactly = 1) { repository.getAllShortAppDetails() }
    }

    @Test
    fun `invoke should return empty list when repository returns empty`() = runTest {
        coEvery { repository.getAllShortAppDetails() } returns emptyList()

        val result = useCase.invoke()

        assertTrue(result.isEmpty())
        coVerify(exactly = 1) { repository.getAllShortAppDetails() }
    }

    @Test(expected = Exception::class)
    fun `invoke should throw exception when repository throws`() = runTest {
        coEvery { repository.getAllShortAppDetails() } throws Exception("Database error")

        useCase.invoke()
    }

    @Test
    fun `invoke should call repository multiple times`() = runTest {
        val mockList = listOf(ShortAppDetails(id = "1", name = "App", category = com.practicum.vkeducation.domain.appdetails.Category.GAME, iconUrl = "icon.png", shortDescription = "Desc"))
        coEvery { repository.getAllShortAppDetails() } returns mockList

        repeat(3) { useCase.invoke() }

        coVerify(exactly = 3) { repository.getAllShortAppDetails() }
    }

    @Test
    fun `invoke should return data correctly`() = runTest {
        val expectedList = listOf(
            ShortAppDetails(id = "10", name = "App10", category = com.practicum.vkeducation.domain.appdetails.Category.EDUCATION, iconUrl = "icon10.png", shortDescription = "Desc10")
        )
        coEvery { repository.getAllShortAppDetails() } returns expectedList

        val result = useCase.invoke()

        assertEquals("10", result[0].id)
        assertEquals("App10", result[0].name)
        assertEquals("icon10.png", result[0].iconUrl)
        assertEquals("Desc10", result[0].shortDescription)
    }
}