package com.jbarrientos.network.di

import com.jbarrientos.network.api.ApiService
import com.jbarrientos.network.datasource.daylistdatasource.DayListDataSource
import com.jbarrientos.network.datasource.daylistdatasource.DayListDataSourceImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
    private const val NIA_BASE_URL = "https://epic.gsfc.nasa.gov/"

    @Provides
    @Singleton
    fun okHttpCallFactory(): Call.Factory = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                }
        )
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun moshiConverterFactory(): Converter.Factory = MoshiConverterFactory
        .create(
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        )


    @Provides
    @Singleton
    fun provideNetworkApi(): Retrofit = Retrofit.Builder()
        .baseUrl(NIA_BASE_URL)
        .callFactory(okHttpCallFactory())
        .addConverterFactory(moshiConverterFactory())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesDayListDataSource(apiService: ApiService): DayListDataSource =
        DayListDataSourceImpl(apiService)
}
