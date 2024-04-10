package com.jbarrientos.daylist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbarrientos.common.Result
import com.jbarrientos.epicjb.ui.component.LoadingWheel

@Composable
fun DayListScreen(
    viewModel: DayListViewModel = hiltViewModel()
) {
    val dayListState by viewModel.dayListState.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when (dayListState) {
            is Result.Error -> TODO()
            is Result.Loading -> LoadingWheel()
            is Result.Success -> LazyColumn {
                items((dayListState as Result.Success).data) { day ->
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(8.dp),
                        text = day.date
                    )
                }
            }
        }
    }
}