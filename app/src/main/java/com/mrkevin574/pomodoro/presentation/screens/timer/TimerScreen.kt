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
    val timerTextState = viewModel.timerTextState.value

    val pomodoro = Pomodoro(
        name = "Test",
        jobTime = 60000,
        shortBreak = 15000f,
        longBreak = 30000f,
        actualTimeRunning = 60000
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
        ContainerTimer(pomorodoTimer.progress, timerTextState.actualTime)
        ButtonsTimer(onClick = {}, isPlay = false)
    }

    LaunchedEffect(pomodoro){
        viewModel.createNewTask(pomodoro)
    }

}

@Composable
fun ContainerTimer(progress : Float, timerText : String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        contentAlignment = Alignment.Center
    ) {

        CircleTimerProgress(progress = progress)
        TextTimerProgress(time = timerText)
    }
}
