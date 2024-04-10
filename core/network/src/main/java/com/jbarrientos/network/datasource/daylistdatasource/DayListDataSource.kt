package com.jbarrientos.network.datasource.daylistdatasource

import com.jbarrientos.network.entity.DayList
import retrofit2.Response

interface DayListDataSource {

    suspend fun getDayList(): Response<List<DayList>>
}
