package com.mrkevin574.pomodoro.presentation.screens.timer

import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrkevin574.pomodoro.domain.Pomodoro
import com.mrkevin574.pomodoro.domain.PomodoroRepository
import com.mrkevin574.pomodoro.util.Cycles
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TimerViewModel @Inject constructor(
    private val repository: PomodoroRepository
) : ViewModel() {

    private val _pomodoroState = mutableStateOf(Pomodoro())
    val pomodoroState: State<Pomodoro> = _pomodoroState

    private val _pomodoroTimerState = mutableStateOf(CircleTimerProgressState())
    val pomodoroTimerState: State<CircleTimerProgressState> = _pomodoroTimerState

    private var timer: CountDownTimer? = null


    fun createNewTask(pomodoro: Pomodoro) {
        _pomodoroState.value = pomodoroState.value.copy(
            name = pomodoro.name,
            jobTime = pomodoro.jobTime,
            shortBreak = pomodoro.shortBreak,
            longBreak = pomodoro.longBreak,
            actualCycle = pomodoro.actualCycle,
            isRunning = pomodoro.isRunning,
            actualTimeRunning = pomodoro.actualTimeRunning
        )

        timer = object : CountDownTimer(pomodoroState.value.actualTimeRunning, 1) {
            override fun onTick(millisUntilFinished: Long) {
                _pomodoroTimerState.value = pomodoroTimerState.value.copy(
                    progress = millisUntilFinished / pomodoroState.value.actualTimeRunning.toFloat()
                )
            }

            override fun onFinish() {
                when (pomodoroState.value.actualCycle) {
                    Cycles.FIRST -> {
                        _pomodoroState.value = pomodoroState.value.copy(
                            actualCycle = Cycles.SHORT_BREAK,
                            actualTimeRunning = pomodoroState.value.shortBreak.toLong()
                        )
                        _pomodoroTimerState.value = pomodoroTimerState.value.copy(
                            progress = 1f
                        )
                    }
                    Cycles.SHORT_BREAK -> {
                        _pomodoroState.value = pomodoroState.value.copy(
                            actualCycle = Cycles.MEDIUM,
                            actualTimeRunning = pomodoroState.value.jobTime.toLong()
                        )
                    }
                    Cycles.MEDIUM -> {
                        _pomodoroState.value = pomodoroState.value.copy(
                            actualCycle = Cycles.LONG_BREAK,
                            actualTimeRunning = pomodoroState.value.longBreak.toLong()
                        )
                    }
                    Cycles.LONG_BREAK -> {
                        _pomodoroState.value = pomodoroState.value.copy(
                            actualCycle = Cycles.LAST
                        )

                    }
                    Cycles.LAST -> {
                        return
                    }
                }
                restartProgressAndTime()
            }
        }

        timer!!.start()
    }

    private fun restartProgressAndTime()
    {
        _pomodoroTimerState.value = pomodoroTimerState.value.copy(
            progress = 1f
        )
        timer?.cancel()
        timer?.start()
    }

    /* fun finalizePomorodo()
     {
         repository.savePomorodo()
     }*/

}