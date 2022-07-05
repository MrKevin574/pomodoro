package com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.mrkevin574.pomodoro.R
import com.mrkevin574.pomodoro.domain.Pomodoro
import com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.components.*
import com.mrkevin574.pomodoro.ui.theme.BackgroundAlertDialog

@Composable
fun AlertDialogNewTask(
    startTask: (Pomodoro) -> Unit,
    optionTask: OptionTask,
    onOptionSelected : (OptionTask) -> Unit,
    isDialogOpen : MutableState<Boolean> = mutableStateOf(true),
    changeCreateTask : () -> Unit
) {
    val pomodoro = Pomodoro()
    
    if(isDialogOpen.value){
        Dialog(
            onDismissRequest = {
                isDialogOpen.value = false
                changeCreateTask()
            }
        ) {
            when(optionTask)
            {
                OptionTask.NAME -> {
                    OptionTaskName(onSelectName = {
                        pomodoro.name = it
                        onOptionSelected(OptionTask.NAME)
                    })
                }
                OptionTask.JOB_TIME -> {
                    SelectJobTime(onSelectJobTime = {
                        pomodoro.jobTime = it
                        onOptionSelected(OptionTask.JOB_TIME)
                    })
                }
                OptionTask.SHORT_BREAK -> {
                    SelectShortBreak(onSelectShortBreak ={
                        pomodoro.shortBreak = it
                        onOptionSelected(OptionTask.SHORT_BREAK)
                    })
                }
                OptionTask.LONG_BREAK -> {
                    SelectLongBreak(onOptionSelect = {
                        pomodoro.longBreak = it
                        isDialogOpen.value = false
                        startTask(pomodoro)
                    })
                }
            }
        }
    }
}


