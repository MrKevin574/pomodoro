package com.mrkevin574.pomodoro.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mrkevin574.pomodoro.presentation.screens.MainScreen
import com.mrkevin574.pomodoro.ui.theme.PomodoroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PomodoroTheme {
                MainScreen()
            }
        }
    }
}

