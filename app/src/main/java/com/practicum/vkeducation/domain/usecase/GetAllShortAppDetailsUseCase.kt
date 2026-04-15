package com.practicum.vkeducation.domain.usecase

import com.practicum.vkeducation.domain.repository.HomeRepository
import javax.inject.Inject

class GetAllShortAppDetailsUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke() = repository.getAllShortAppDetails()
}