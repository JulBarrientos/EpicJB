package com.jbarrientos.epicjb.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jbarrientos.daylist.DAY_LIST_ROUTE
import com.jbarrientos.daylist.dayListScreen
import com.jbarrientos.photolist.photoListScreen

@Composable
fun AppNavigationGraph(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = DAY_LIST_ROUTE) {
        dayListScreen()
        photoListScreen()
    }
}