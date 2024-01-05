package com.jbarrientos.epicjb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jbarrientos.epicjb.ui.navigation.AppNavigationGraph
import com.jbarrientos.epicjb.ui.theme.EpicJBTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EpicJBTheme {
                Surface (
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    AppEntryPoint()
                }
            }
        }
    }

    @Composable
    fun AppEntryPoint(){
        AppNavigationGraph()
    }
}