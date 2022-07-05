package com.mrkevin574.pomodoro.presentation.screens.log

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrkevin574.pomodoro.data.local.PomodoroEntity

@Composable
fun PomodoroItem(pomodoro: PomodoroEntity) {
    Column(
        modifier = Modifier.padding(top = 50.dp, start = 50.dp, end = 50.dp)
    ) {
        Text(
            text = pomodoro.name.replaceFirstChar { it.uppercase() },
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        TextSecondaryTask("Date created: ${pomodoro.date}")
        TextSecondaryTask("Cycles completed: ${pomodoro.cycles}")
        TextSecondaryTask("Total focused time: ${pomodoro.focusedTime}")
    }
}

@Composable
fun TextSecondaryTask(text : String)
{
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = Color.White
    )
}