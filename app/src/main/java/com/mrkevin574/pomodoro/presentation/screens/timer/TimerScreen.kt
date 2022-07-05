package com.mrkevin574.pomodoro.presentation.screens.timer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mrkevin574.pomodoro.R
import com.mrkevin574.pomodoro.presentation.screens.timer.components.*
import com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.AlertDialogNewTask
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
    val stateCreateTask = viewModel.createTask.value
    val actualDialog = viewModel.alertDialogOptionState.value

    val colorTimer = getColorTimer(pomorodoState.actualCycle)
    val alphaBreak = getAlphaBreak(pomorodoState.actualCycle)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        TextTakeABreak(alphaBreak)
        ContainerTimer(pomorodoTimer.progress, timerTextState.actualTime, colorTimer)
        if (pomodoroExists) {
            ButtonsTimer(
                onClick = { viewModel.onEvent(it) },
                isPlay = pomorodoState.isRunning,
                colorButtons = colorTimer
            )
        } else {
            ButtonAddTask {
                viewModel.changeCreateTaskState()
            }
        }
    }

    if (stateCreateTask) {
        AlertDialogNewTask()
    }
}

@Composable
fun ContainerTimer(progress: Float, timerText: String, colorTimer: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        CircleTimerProgress(progress = progress, colorTimer)
        TextTimerProgress(time = timerText, colorTimer)
    }
}

@Composable
fun TextTakeABreak(alphaBreak: Float) {
    Text(
        text = stringResource(R.string.take_a_break),
        color = BreakColor,
        modifier = Modifier
            .fillMaxWidth()
            .alpha(alphaBreak),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    )
}

private fun getColorTimer(cycle: Cycles): Color {
    return if (cycle == Cycles.SHORT_BREAK ||
        cycle == Cycles.LONG_BREAK
    ) BreakColor else Color.White
}

private fun getAlphaBreak(cycle: Cycles): Float {
    return if (cycle == Cycles.SHORT_BREAK ||
        cycle == Cycles.LONG_BREAK
    ) 1f else 0f
}
