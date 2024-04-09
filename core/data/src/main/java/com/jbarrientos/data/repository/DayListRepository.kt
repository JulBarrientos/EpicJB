package com.jbarrientos.data.repository

import com.jbarrientos.network.datasource.daylistdatasource.DayListDataSource
import com.jbarrientos.network.entity.DayList
import retrofit2.Response
import javax.inject.Inject

class DayListRepository @Inject constructor(
    private val dayListDataSource: DayListDataSource
) {

    suspend fun getDayList(): Response<DayList> =
        dayListDataSource.getDayList()
}
