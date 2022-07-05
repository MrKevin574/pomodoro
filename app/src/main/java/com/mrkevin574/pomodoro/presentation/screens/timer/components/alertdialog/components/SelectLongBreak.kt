package com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mrkevin574.pomodoro.R

@Composable
fun SelectLongBreak(onOptionSelect : (Float) -> Unit) {
    val longBreaks = listOf(
        stringResource(id = R.string.minutes_2o),
        stringResource(id = R.string.minutes_25),
        stringResource(id = R.string.minutes_30)
    )
    RadioGroupButtons(label = stringResource(R.string.select_long_break), listButtons = longBreaks, onOptionSelect = {
        when(it)
        {
            longBreaks[0] -> {
                onOptionSelect(20 * 60 * 1000f)
            }
            longBreaks[1] -> {
                onOptionSelect(25 * 60 * 1000f)
            }
            longBreaks[2] -> {
                onOptionSelect(30 * 60 * 1000f)
            }
        }
    } )
}