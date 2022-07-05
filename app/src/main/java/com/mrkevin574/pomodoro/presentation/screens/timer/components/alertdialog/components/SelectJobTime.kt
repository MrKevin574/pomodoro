package com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mrkevin574.pomodoro.R

@Composable
fun SelectJobTime(onSelectJobTime : (Long) -> Unit) {
    val jobTimes = listOf(
        stringResource(R.string.minutes_2o),
        stringResource(R.string.minutes_25),
        stringResource(R.string.minutes_30)
        )
    RadioGroupButtons(label = stringResource(R.string.select_task_time), listButtons = jobTimes, onOptionSelect = {
        when(it)
        {
            jobTimes[0] -> {
                onSelectJobTime(20 * 60 * 1000)
            }
            jobTimes[1] -> {
                onSelectJobTime(25 * 60 * 1000)
            }
            jobTimes[2] -> {
                onSelectJobTime(30 * 60 * 1000)
            }
        }
    } )
}