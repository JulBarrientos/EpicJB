package com.jbarrientos.daylist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbarrientos.common.Result
import com.jbarrientos.epicjb.ui.component.LoadingWheel
import com.jbarrientos.epicjb.ui.theme.endGradientBackgroundColor
import com.jbarrientos.epicjb.ui.theme.startGradientBackgroundColor
import com.jbarrientos.network.entity.DayList
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DayListScreen(
    viewModel: DayListViewModel = hiltViewModel()
) {
    val dayListState by viewModel.dayListState.collectAsState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when (dayListState) {
            is Result.Error -> TODO()
            is Result.Loading -> LoadingWheel()
            is Result.Success -> DayList(
                days = (dayListState as Result.Success).data
            )
        }
    }

}

@Composable
fun DayList(days: List<DayList>) {
    Column(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.0f to startGradientBackgroundColor,
                        0.15f to endGradientBackgroundColor
                    )
                )
            )
    ) {
        Text(
            text = "Daily Images",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, bottom = 16.dp, top = 16.dp),
            fontSize = 28.sp,
            color = Color.White
        )
        LazyColumn {
            items(days, key = {it.date}) { day ->
                DayCard(
                    date = LocalDate.parse(day.date, DateTimeFormatter.ISO_DATE)
                )
            }
        }
    }
}

@Composable
fun DayCard(date: LocalDate) {
    val dayOfWeek = date.dayOfWeek.toString()
    val dateFormatted = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    val goToPhotoList = LocalOnClickDay.current
    Card(
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .padding(start = 24.dp, end = 24.dp, bottom = 8.dp, top = 8.dp)
            .clickable (
                onClick = { goToPhotoList(dayOfWeek, date.toString()) }
            ),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = dayOfWeek,
                    color = Color.White,
                    fontSize = 21.sp,
                )
                Text(
                    text = dateFormatted,
                    color = Color(0xFFB2B7BD)
                )

            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = "")
            }
        }
    }
}
