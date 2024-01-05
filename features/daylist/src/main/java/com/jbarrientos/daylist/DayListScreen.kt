package com.jbarrientos.daylist

import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DayListScreen(
    dayListViewModel: DayListViewModel = hiltViewModel()
){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Hello World!")
    }
}