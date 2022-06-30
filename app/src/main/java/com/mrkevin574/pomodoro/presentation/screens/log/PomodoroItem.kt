package com.mrkevin574.pomodoro.presentation.screens.log

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrkevin574.pomodoro.domain.Pomodoro

@Composable
fun PomodoroItem(pomodoro: Pomodoro) {
    Column(
        modifier = Modifier.padding(top = 50.dp, start = 50.dp, end = 50.dp)
    ) {
        Text(
            text = pomodoro.name.replaceFirstChar { it.uppercase() },
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = "Date created: ${pomodoro.date}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
        Text(
            text = "Cycles completed: ${pomodoro.cycles}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
        Text(
            text = "Total focused time: ${pomodoro.focusedTime}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
    }
}