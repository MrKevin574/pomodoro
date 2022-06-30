package com.mrkevin574.pomodoro.presentation.screens.timer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mrkevin574.pomodoro.domain.Pomodoro

@Composable
fun TimerScreen(
    viewModel: TimerViewModel = hiltViewModel()
) {

    val pomorodoTimer = viewModel.pomodoroTimerState.value
    val pomorodoState = viewModel.pomodoroState.value

    val pomodoro = Pomodoro(
        name = "Test",
        jobTime = 10000,
        shortBreak = 5000f,
        longBreak = 10000f,
        actualTimeRunning = 10000
    )


    Text(
        text =  "${pomorodoState.actualCycle} - ${pomorodoState.actualTimeRunning/1000}"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ButtonAddTask {

        }
        ContainerTimer(pomorodoTimer.progress)
        ButtonsTimer(onClick = {}, isPlay = false)
    }

    LaunchedEffect(pomodoro){
        viewModel.createNewTask(pomodoro)
    }

}

@Composable
fun ContainerTimer(progress : Float) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        contentAlignment = Alignment.Center
    ) {

        CircleTimerProgress(progress = progress)
        TextTimerProgress(time = "12:00")
    }
}
