package com.mrkevin574.pomodoro.presentation.screens.timer

import androidx.lifecycle.ViewModel
import com.mrkevin574.pomodoro.domain.PomodoroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TimerViewModel @Inject constructor(
    repository: PomodoroRepository
) : ViewModel() {

}