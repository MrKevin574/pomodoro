package com.mrkevin574.pomodoro.presentation.screens.log

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrkevin574.pomodoro.data.local.PomodoroEntity
import com.mrkevin574.pomodoro.domain.PomodoroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogViewModel @Inject constructor(private val repository: PomodoroRepository) : ViewModel()
{
    val pomodoros = mutableStateOf(listOf<PomodoroEntity>())
    init {
        viewModelScope.launch {
            pomodoros.value = repository.getAllPomodoro()
        }

    }
}