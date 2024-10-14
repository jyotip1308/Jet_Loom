package com.android.jetloom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.jetloom.navigation.Navigate
import com.android.jetloom.ui.theme.JetLoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetLoomTheme {
              Navigate()
            }
        }
    }
}

