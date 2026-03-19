package com.practicum.vkeducation.domain.usecase

import com.practicum.vkeducation.domain.repository.HomeRepository

class GetShortAppDetailsUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke() = repository.getShortAppDetails()
}