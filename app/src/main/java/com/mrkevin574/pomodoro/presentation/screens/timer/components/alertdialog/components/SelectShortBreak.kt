package com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mrkevin574.pomodoro.R

@Composable
fun SelectShortBreak(onSelectShortBreak : (Float) -> Unit) {
    val shortBreaks = listOf(
        stringResource(R.string.minutes_5),
        stringResource(R.string.minutes_10),
        stringResource(R.string.minutes_15)
            )
    RadioGroupButtons(label = stringResource(R.string.select_short_break), listButtons = shortBreaks, onOptionSelect = {
        when(it)
        {
            shortBreaks[0] -> { onSelectShortBreak(5 * 60 * 1000f)}
            shortBreaks[1] -> { onSelectShortBreak(10 * 60 * 1000f)}
            shortBreaks[2] -> { onSelectShortBreak(15 * 60 * 1000f)}
        }
    })
}