package com.jbarrientos.network.api

import com.jbarrientos.network.entity.DayList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/enhanced/all")
    suspend fun getDayList(): Response<List<DayList>>
}