package com.mrkevin574.pomodoro.presentation.screens.timer.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mrkevin574.pomodoro.R

@Composable
fun TextTimerProgress(time : String, color: Color) {
    Text(
        text = time.ifEmpty { stringResource(R.string.pomodoro) },
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        color = color
    )

}