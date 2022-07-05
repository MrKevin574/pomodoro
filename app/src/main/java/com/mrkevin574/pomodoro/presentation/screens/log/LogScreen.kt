package com.mrkevin574.pomodoro.presentation.screens.log

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import java.util.*

@Composable
fun LogScreen(
    viewModel: LogViewModel = hiltViewModel()
) {

    val pomodoros = viewModel.pomodoros.value

    LazyColumn(modifier = Modifier.fillMaxSize())
    {
        items(pomodoros)
        {
            PomodoroItem(it)
        }
    }
}