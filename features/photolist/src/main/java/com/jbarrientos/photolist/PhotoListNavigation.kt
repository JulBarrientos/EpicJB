package com.jbarrientos.photolist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val PHOTO_LIST_ROUTE = "photo_list_route"

fun NavGraphBuilder.photoListScreen() {
    composable(route = PHOTO_LIST_ROUTE) {
        PhotoListScreen()
    }
}