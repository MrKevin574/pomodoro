package com.mrkevin574.pomodoro.presentation.screens.timer

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TimerScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ButtonAddTask {

        }
        ContainerTimer()
        ButtonsTimer(onClick = {}, isPlay = false)
    }




}

@Composable
fun ContainerTimer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        contentAlignment = Alignment.Center
    ) {

        CircleTimerProgress(progress = 1f)
        TextTimerProgress(time = "12:00")
    }
}
