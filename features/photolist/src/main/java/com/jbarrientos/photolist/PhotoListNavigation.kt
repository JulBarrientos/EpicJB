package com.jbarrientos.photolist

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jbarrientos.common.PHOTO_LIST_ROUTE

private const val dayOfWeekIdArg = "dayOfWeek"
private const val dateIdArg = "date"

fun NavGraphBuilder.photoListScreen(onBackClick: () -> Unit) {
    composable(route = "$PHOTO_LIST_ROUTE/{$dayOfWeekIdArg}/{$dateIdArg}") {
        PhotoListScreen(onBackClick)
    }
}

fun NavController.navigateToPhotoListFromDay(day: String, date: String) {
    this.navigate("$PHOTO_LIST_ROUTE/$day/$date")
}

internal fun getDayOfWeekFromState(savedStateHandle: SavedStateHandle): String {
    return (checkNotNull(savedStateHandle[dayOfWeekIdArg]) as String)
}

internal fun getDateFromState(savedStateHandle: SavedStateHandle): String {
    return (checkNotNull(savedStateHandle[dateIdArg]) as String)
}