package com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mrkevin574.pomodoro.R
import com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.components.RadioGroupButtons

@Composable
fun SelectJobTime(onSelectJobTime : (Long) -> Unit) {
    val job_times = listOf(
        stringResource(R.string.minutes_2o),
        stringResource(R.string.minutes_25),
        stringResource(R.string.minutes_30)
        )
    RadioGroupButtons(label = stringResource(R.string.select_task_time), listButtons = job_times, onOptionSelect = {
        when(it)
        {
            job_times[0] -> {
                onSelectJobTime(20 * 60 * 1000)
            }
            job_times[1] -> {
                onSelectJobTime(25 * 60 * 1000)
            }
            job_times[2] -> {
                onSelectJobTime(30 * 60 * 1000)
            }
        }
    } )
}