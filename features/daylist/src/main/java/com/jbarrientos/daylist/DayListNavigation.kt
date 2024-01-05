package com.jbarrientos.daylist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val DAY_LIST_ROUTE = "day_list_route"

fun NavGraphBuilder.dayListScreen() {
   composable(route = DAY_LIST_ROUTE) {
      DayListScreen()
   }
}