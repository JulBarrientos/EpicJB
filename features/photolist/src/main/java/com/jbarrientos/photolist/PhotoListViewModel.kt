package com.jbarrientos.photolist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class PhotoListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    val dayArgs = getDayOfWeekFromState(savedStateHandle)
    val date = getDateFromState(savedStateHandle)

    private fun getPhotoList() {
    }
}