package com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.components

import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mrkevin574.pomodoro.R

@Composable
fun ButtonNext(onClick : () -> Unit)
{
    OutlinedButton(onClick = onClick ) {
        Text(
            text = stringResource(id = R.string.next)
        )
    }
}