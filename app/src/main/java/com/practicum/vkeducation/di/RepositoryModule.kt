package com.practicum.vkeducation.di

import com.practicum.vkeducation.data.repository.AppDetailsRepositoryImpl
import com.practicum.vkeducation.data.repository.HomeRepositoryImpl
import com.practicum.vkeducation.domain.repository.AppDetailsRepository
import com.practicum.vkeducation.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository

    @Binds
    @Singleton
    abstract fun bindAppDetailsRepository(
        appDetailsRepositoryImpl: AppDetailsRepositoryImpl
    ): AppDetailsRepository
}