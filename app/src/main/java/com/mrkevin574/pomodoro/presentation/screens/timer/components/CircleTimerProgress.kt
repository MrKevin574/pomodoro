package com.mrkevin574.pomodoro.presentation.screens.timer.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.mrkevin574.pomodoro.R

@Composable
fun CircleTimerProgress(progress : Float, color : Color) {
    CircularProgressIndicator(
        progress = progress,
        modifier = Modifier
            .height(400.dp)
            .width(400.dp),
        color = color,
        strokeWidth = dimensionResource(id = R.dimen.timer_progress_stroke)
    )
}