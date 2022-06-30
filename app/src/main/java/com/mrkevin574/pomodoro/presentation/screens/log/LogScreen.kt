package com.mrkevin574.pomodoro.presentation.screens.log

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mrkevin574.pomodoro.domain.PomodoroFinalized
import java.util.*

@Composable
fun LogScreen() {

    val pomodoros = listOf<PomodoroFinalized>(
        PomodoroFinalized(
            name = "Programar",
            date = Date(),
            cycles = 3,
            focusedTime = 30f
        ),
        PomodoroFinalized(
            name = "chingar",
            date = Date(),
            cycles = 3,
            focusedTime = 30f
        ),
        PomodoroFinalized(
            name = "comer",
            date = Date(),
            cycles = 3,
            focusedTime = 30f
        ),
        PomodoroFinalized(
            name = "Programar",
            date = Date(),
            cycles = 3,
            focusedTime = 30f
        ),
        PomodoroFinalized(
            name = "Programar",
            date = Date(),
            cycles = 3,
            focusedTime = 30f
        )
    )

    LazyColumn(modifier = Modifier.fillMaxSize())
    {
        items(pomodoros)
        {
            PomodoroItem(it)
        }
    }
}