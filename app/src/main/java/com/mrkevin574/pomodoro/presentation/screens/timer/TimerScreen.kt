package com.mrkevin574.pomodoro.presentation.screens.timer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mrkevin574.pomodoro.ui.theme.PrimaryColor

@Composable
fun TimerScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        CircleTimerProgress(progress = 1f)
        TextTimerProgress(time = "12:00")
        ButtonsTimer(onClick = {}, isPlay = false)
    }
}