package com.jbarrientos.epicjb

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EpicJBApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}