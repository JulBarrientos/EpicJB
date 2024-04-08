package com.jbarrientos.network.datasource.daylistdatasource

import com.jbarrientos.network.api.ApiService
import com.jbarrientos.network.entity.DayList
import retrofit2.Response
import javax.inject.Inject

class DayListDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : DayListDataSource {

    override suspend fun getDayList(): Response<DayList> =
        apiService.getDayList()
}
