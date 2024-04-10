package com.jbarrientos.data.repository

import com.jbarrientos.network.datasource.daylistdatasource.DayListDataSource
import com.jbarrientos.network.entity.DayList
import com.jbarrientos.common.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DayListRepository @Inject constructor(
    private val dayListDataSource: DayListDataSource
) {

    suspend fun getDayList(): Flow<Result<List<DayList>>> = flow{
        emit(Result.Loading)

        val response = dayListDataSource.getDayList()

        if (response.isSuccessful && response.body()!= null){
            emit(Result.Success(response.body()!!))
        }
    }.catch { e ->
        emit(Result.Error(e))
    }
}
