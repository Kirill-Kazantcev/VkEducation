package com.practicum.vkeducation.data.mapper

import com.practicum.vkeducation.data.dto.ShortAppDetailsDto
import org.junit.Assert.assertEquals
import org.junit.Test

class ShortAppDetailsMapperTest {

    @Test
    fun `toDomain should map id correctly`() {
        val dto = ShortAppDetailsDto(
            id = "123",
            name = "Test App",
            category = "Игры",
            iconUrl = "icon.png",
            shortDescription = "Description"
        )
        val result = dto.toDomain()
        assertEquals("123", result.id)
    }

    @Test
    fun `toDomain should map name correctly`() {
        val dto = ShortAppDetailsDto(
            id = "1",
            name = "My App",
            category = "Игры",
            iconUrl = "icon.png",
            shortDescription = "Desc"
        )
        val result = dto.toDomain()
        assertEquals("My App", result.name)
    }

    @Test
    fun `toDomain should map iconUrl correctly`() {
        val dto = ShortAppDetailsDto(
            id = "1",
            name = "App",
            category = "Игры",
            iconUrl = "https://example.com/icon.png",
            shortDescription = "Desc"
        )
        val result = dto.toDomain()
        assertEquals("https://example.com/icon.png", result.iconUrl)
    }

    @Test
    fun `toDomain should map shortDescription correctly`() {
        val dto = ShortAppDetailsDto(
            id = "1",
            name = "App",
            category = "Игры",
            iconUrl = "icon.png",
            shortDescription = "This is a short description"
        )
        val result = dto.toDomain()
        assertEquals("This is a short description", result.shortDescription)
    }

    @Test
    fun `toDomain should map all fields correctly`() {
        val dto = ShortAppDetailsDto(
            id = "42",
            name = "Complete App",
            category = "Образование",
            iconUrl = "https://example.com/icon.png",
            shortDescription = "Full description"
        )
        val result = dto.toDomain()

        assertEquals(dto.id, result.id)
        assertEquals(dto.name, result.name)
        assertEquals(dto.iconUrl, result.iconUrl)
        assertEquals(dto.shortDescription, result.shortDescription)
    }
}