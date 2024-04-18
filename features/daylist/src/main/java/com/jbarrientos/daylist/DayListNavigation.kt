package com.jbarrientos.daylist

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jbarrientos.common.DAY_LIST_ROUTE

val LocalOnClickDay = compositionLocalOf<(String, String) -> Unit>{ error("No user found!") }
fun NavGraphBuilder.dayListScreen(onDaySelected: (dayOfWeek:String, date:String) -> Unit) {
   composable(route = DAY_LIST_ROUTE) {
      CompositionLocalProvider(LocalOnClickDay provides onDaySelected) {
         DayListScreen()
      }
   }
}