package com.practicum.vkeducation.domain.usecase

import com.practicum.vkeducation.domain.repository.AppDetailsRepository
import javax.inject.Inject

class GetAppDetailsUseCase @Inject constructor(
    private val repository: AppDetailsRepository
) {
    suspend operator fun invoke() = repository.getAppDetails()
}