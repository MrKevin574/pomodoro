package com.mrkevin574.pomodoro.presentation.screens.log

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mrkevin574.pomodoro.presentation.screens.timer.TimerViewModel

@Composable
fun LogScreen(
    viewModel: TimerViewModel = hiltViewModel()
) {

    val pomodoroList = viewModel.pomodoroList.value

    LazyColumn(modifier = Modifier.fillMaxSize())
    {
        items(pomodoroList)
        {
            PomodoroItem(it)
        }
    }
}