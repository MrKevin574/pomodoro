package com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.mrkevin574.pomodoro.domain.Pomodoro
import com.mrkevin574.pomodoro.domain.restart
import com.mrkevin574.pomodoro.presentation.screens.timer.TimerViewModel
import com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.components.*

@Composable
fun AlertDialogNewTask(
    viewModel: TimerViewModel = hiltViewModel(),
    isDialogOpen: MutableState<Boolean> = mutableStateOf(true)
) {
    val pomodoro = remember { Pomodoro() }
    val optionTask = viewModel.alertDialogOptionState.value

    if (isDialogOpen.value) {
        Dialog(
            onDismissRequest = {
              //  isDialogOpen.value = false
                viewModel.changeCreateTaskState()
            }
        ) {
            Card(
                shape = RoundedCornerShape(40.dp)
            ) {
                when (optionTask) {
                    OptionTask.NAME -> {
                        OptionTaskName(onSelectName = {
                            pomodoro.name = it
                            viewModel.onOptionSelected(OptionTask.NAME)
                        })
                    }
                    OptionTask.JOB_TIME -> {
                        SelectJobTime(onSelectJobTime = {
                            pomodoro.jobTime = it
                            pomodoro.actualTimeRunning = it
                            viewModel.onOptionSelected(OptionTask.JOB_TIME)
                        })
                    }
                    OptionTask.SHORT_BREAK -> {
                        SelectShortBreak(onSelectShortBreak = {
                            pomodoro.shortBreak = it
                            viewModel.onOptionSelected(OptionTask.SHORT_BREAK)
                        })
                    }
                    OptionTask.LONG_BREAK -> {
                        SelectLongBreak(onOptionSelect = {
                            pomodoro.longBreak = it
                            isDialogOpen.value = false
                            viewModel.changeCreateTaskState()
                            viewModel.startTask(pomodoro)
                            pomodoro.restart()
                        })
                    }
                }
            }
        }
    }
}



