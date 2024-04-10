package com.jbarrientos.daylist

import com.jbarrientos.network.entity.DayList

sealed interface DayListState {
    data object Loading: DayListState
    data object Error: DayListState
    data class Success(
        val dayList: List<DayList>
    ): DayListState
}