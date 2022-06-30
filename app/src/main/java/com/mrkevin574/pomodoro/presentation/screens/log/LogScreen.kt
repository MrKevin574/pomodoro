package com.mrkevin574.pomodoro.presentation.screens.log

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mrkevin574.pomodoro.domain.Pomodoro
import java.util.*

@Composable
fun LogScreen() {

    val pomodoros = listOf<Pomodoro>(
        Pomodoro(
            name = "Programar",
            date = Date(),
            cycles = 3,
            focusedTime = 30f
        ),
        Pomodoro(
            name = "chingar",
            date = Date(),
            cycles = 3,
            focusedTime = 30f
        ),
        Pomodoro(
            name = "comer",
            date = Date(),
            cycles = 3,
            focusedTime = 30f
        ),
        Pomodoro(
            name = "Programar",
            date = Date(),
            cycles = 3,
            focusedTime = 30f
        ),
        Pomodoro(
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