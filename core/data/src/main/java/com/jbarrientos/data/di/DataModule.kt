package com.jbarrientos.data.di

import com.jbarrientos.data.repository.DayListRepository
import com.jbarrientos.network.datasource.daylistdatasource.DayListDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataModule {

    @Provides
    @Singleton
    fun providesDayListRepository(dayListDataSource: DayListDataSource): DayListRepository =
        DayListRepository(dayListDataSource)
}