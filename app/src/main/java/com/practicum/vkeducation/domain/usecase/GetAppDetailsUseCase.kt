package com.practicum.vkeducation.domain.usecase

import com.practicum.vkeducation.domain.repository.AppDetailsRepository

class GetAppDetailsUseCase(
    private val repository: AppDetailsRepository
) {
    suspend operator fun invoke() = repository.getAppDetails()
}