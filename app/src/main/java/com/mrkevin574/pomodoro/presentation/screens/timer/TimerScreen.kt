package com.mrkevin574.pomodoro.presentation.screens.timer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mrkevin574.pomodoro.R
import com.mrkevin574.pomodoro.domain.Pomodoro
import com.mrkevin574.pomodoro.ui.theme.BreakColor
import com.mrkevin574.pomodoro.util.Cycles

@Composable
fun TimerScreen(
    viewModel: TimerViewModel = hiltViewModel()
) {

    val pomorodoTimer = viewModel.pomodoroTimerState.value
    val pomorodoState = viewModel.pomodoroState.value
    val timerTextState = viewModel.timerTextState.value
    val pomodoroExists = pomorodoState.name.isNotEmpty()

       val pomodoro = Pomodoro(
           name = "Test",
           jobTime = 60000,
           shortBreak = 15000f,
           longBreak = 30000f,
           actualTimeRunning = 60000
       )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        if(pomorodoState.actualCycle == Cycles.SHORT_BREAK || pomorodoState.actualCycle == Cycles.LONG_BREAK )
        {
            TextTakeABreak()
        }

        ContainerTimer(pomorodoTimer.progress, timerTextState.actualTime, pomorodoState.actualCycle)
        if (pomodoroExists) {
            ButtonsTimer(onClick = { viewModel.onEvent(it) }, isPlay = pomorodoState.isRunning)
        } else {
            ButtonAddTask {

            }
        }
    }

     LaunchedEffect(pomodoro){
         viewModel.startTask(pomodoro)
     }

}

@Composable
fun ContainerTimer(progress: Float, timerText: String, cycle: Cycles) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        contentAlignment = Alignment.Center,
    ) {

        val colorTimer = if(cycle == Cycles.SHORT_BREAK || cycle == Cycles.LONG_BREAK) BreakColor else Color.White
        CircleTimerProgress(progress = progress, colorTimer)
        TextTimerProgress(time = timerText, colorTimer)
    }
}

@Composable
fun TextTakeABreak()
{
    Text(
        text = stringResource(R.string.take_a_break),
        color = BreakColor,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    )
}
