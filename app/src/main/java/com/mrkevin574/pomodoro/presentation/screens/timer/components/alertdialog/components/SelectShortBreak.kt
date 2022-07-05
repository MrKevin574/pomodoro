package com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mrkevin574.pomodoro.R

@Composable
fun SelectShortBreak(onSelectShortBreak : (Float) -> Unit) {
    val short_breaks = listOf(
        stringResource(R.string.minutes_5),
        stringResource(R.string.minutes_10),
        stringResource(R.string.minutes_15)
            )
    RadioGroupButtons(label = stringResource(R.string.select_short_break), listButtons = short_breaks, onOptionSelect = {
        when(it)
        {
            short_breaks[0] -> { onSelectShortBreak(5000f)}
            short_breaks[1] -> { onSelectShortBreak(10000f)}
            short_breaks[2] -> { onSelectShortBreak(15000f)}
        }
    })
}