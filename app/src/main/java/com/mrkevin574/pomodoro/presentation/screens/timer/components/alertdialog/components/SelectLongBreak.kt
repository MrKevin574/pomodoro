package com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mrkevin574.pomodoro.R

@Composable
fun SelectLongBreak(onOptionSelect : (Float) -> Unit) {
    val long_breaks = listOf(
        stringResource(id = R.string.minutes_2o),
        stringResource(id = R.string.minutes_25),
        stringResource(id = R.string.minutes_30)
    )
    RadioGroupButtons(label = stringResource(R.string.select_long_break), listButtons = long_breaks, onOptionSelect = {
        when(it)
        {
            long_breaks[0] -> {
                onOptionSelect(20000f)
            }
            long_breaks[1] -> {
                onOptionSelect(25000f)
            }
            long_breaks[2] -> {
                onOptionSelect(30000f)
            }
        }
    } )
}