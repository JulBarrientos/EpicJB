package com.jbarrientos.daylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbarrientos.common.Result
import com.jbarrientos.common.asResult
import com.jbarrientos.data.repository.DayListRepository
import com.jbarrientos.network.entity.DayList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DayListViewModel @Inject constructor(
    private val dayListRepository: DayListRepository
) : ViewModel() {

    private val _dayList: MutableStateFlow<Result<List<DayList>>> = MutableStateFlow(Result.Loading)
    val dayListState: StateFlow<Result<List<DayList>>> = _dayList

    init {
        getDayList()
    }
    private fun getDayList() {
        viewModelScope.launch {
            dayListRepository.getDayList().collectLatest {
                _dayList.value = it
            }
        }
    }
}
