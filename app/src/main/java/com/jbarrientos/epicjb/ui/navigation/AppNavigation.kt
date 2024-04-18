package com.jbarrientos.epicjb.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jbarrientos.common.DAY_LIST_ROUTE
import com.jbarrientos.daylist.dayListScreen
import com.jbarrientos.photolist.navigateToPhotoListFromDay
import com.jbarrientos.photolist.photoListScreen

@Composable
fun AppNavigationGraph(
    navController: NavHostController = rememberNavController()
){
    NavHost(navController = navController, startDestination = DAY_LIST_ROUTE) {
        dayListScreen(onDaySelected = navController::navigateToPhotoListFromDay)
        photoListScreen(navController::popBackStack)
    }
}