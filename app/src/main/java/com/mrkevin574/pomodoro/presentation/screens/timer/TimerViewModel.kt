package com.mrkevin574.pomodoro.presentation.screens.timer

import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mrkevin574.pomodoro.domain.Pomodoro
import com.mrkevin574.pomodoro.domain.PomodoroRepository
import com.mrkevin574.pomodoro.presentation.Event
import com.mrkevin574.pomodoro.util.Cycles
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TimerViewModel @Inject constructor(
    private val repository: PomodoroRepository
) : ViewModel() {

    private val _pomodoroState = mutableStateOf(Pomodoro())
    val pomodoroState: State<Pomodoro> = _pomodoroState

    private val _pomodoroTimerState = mutableStateOf(CircleTimerProgressState())
    val pomodoroTimerState: State<CircleTimerProgressState> = _pomodoroTimerState

    private val _timerTextState = mutableStateOf(TimerTextState())
    val timerTextState: State<TimerTextState> = _timerTextState

    var isPaused = false

    private var timer: CountDownTimer? = null


    fun startTask(pomodoro: Pomodoro) {
        restartProgress()
        if (!isPaused) {
            _pomodoroState.value = pomodoroState.value.copy(
                name = pomodoro.name,
                jobTime = pomodoro.jobTime,
                shortBreak = pomodoro.shortBreak,
                longBreak = pomodoro.longBreak,
                actualCycle = pomodoro.actualCycle,
                isRunning = true,
                actualTimeRunning = pomodoro.actualTimeRunning,
                timeRunningInmutable = pomodoro.actualTimeRunning
            )
        } else {
            isPaused = false
        }

        timer = object : CountDownTimer(pomodoroState.value.actualTimeRunning, 1) {
            override fun onTick(millisUntilFinished: Long) {
                _pomodoroState.value = pomodoroState.value.copy(
                    actualTimeRunning = millisUntilFinished
                )
                _pomodoroTimerState.value = pomodoroTimerState.value.copy(
                    progress = millisUntilFinished / pomodoroState.value.timeRunningInmutable.toFloat()
                )
                _timerTextState.value = timerTextState.value.copy(
                    actualTime = "${(millisUntilFinished / 1000 / 60).toInt()}:${(millisUntilFinished / 1000 % 60).toInt()}"
                )
            }

            override fun onFinish() {
                nextCycle()
            }
        }

        timer!!.start()
    }

    fun onEvent(event: Event) {
        when (event) {
            Event.Next -> {
                timer?.cancel()
                nextCycle()
            }
            Event.Play -> {
                timer?.start()
                _pomodoroState.value = pomodoroState.value.copy(
                    isRunning = true
                )
            }
            Event.Resume -> {
                changePomodoroRunning(true)
                startTask(pomodoroState.value)

            }
            Event.Stop -> {
                timer?.cancel()
                restartProgress()
                finalizePomorodo()
            }
            Event.Pause -> {
                isPaused = true
                timer?.cancel()
                changePomodoroRunning(false)
            }
        }
    }

    private fun nextCycle() {
        when (pomodoroState.value.actualCycle) {
            Cycles.FIRST -> {
                _pomodoroState.value = pomodoroState.value.copy(
                    actualCycle = Cycles.SHORT_BREAK,
                    actualTimeRunning = pomodoroState.value.shortBreak.toLong(),
                    timeRunningInmutable = pomodoroState.value.shortBreak.toLong(),
                )
                _pomodoroTimerState.value = pomodoroTimerState.value.copy(
                    progress = 1f
                )
                startTask(pomodoroState.value)
            }
            Cycles.SHORT_BREAK -> {
                _pomodoroState.value = pomodoroState.value.copy(
                    actualCycle = Cycles.MEDIUM,
                    actualTimeRunning = pomodoroState.value.jobTime,
                    timeRunningInmutable = pomodoroState.value.jobTime,
                )
                startTask(pomodoroState.value)
            }
            Cycles.MEDIUM -> {
                _pomodoroState.value = pomodoroState.value.copy(
                    actualCycle = Cycles.LONG_BREAK,
                    actualTimeRunning = pomodoroState.value.longBreak.toLong(),
                    timeRunningInmutable = pomodoroState.value.longBreak.toLong()
                )
                startTask(pomodoroState.value)
            }
            Cycles.LONG_BREAK -> {
                _pomodoroState.value = pomodoroState.value.copy(
                    actualCycle = Cycles.LAST,
                    actualTimeRunning = pomodoroState.value.jobTime,
                    timeRunningInmutable = pomodoroState.value.jobTime
                )
                startTask(pomodoroState.value)
            }
            Cycles.LAST -> {
                return
            }
        }
    }

    private fun restartProgress() {
        _pomodoroTimerState.value = pomodoroTimerState.value.copy(
            progress = 1f
        )
        _timerTextState.value = timerTextState.value.copy(
            actualTime = "00:00"
        )
        _pomodoroState.value = pomodoroState.value.copy(
            name = "",
            actualTimeRunning = 0,
            timeRunningInmutable = 0,
            jobTime = 0,
            shortBreak = 0f,
            longBreak = 0f,
            actualCycle = Cycles.FIRST,
            isRunning = false
        )
    }

    private fun changePomodoroRunning(value: Boolean) {
        _pomodoroState.value = pomodoroState.value.copy(
            isRunning = value
        )
    }

    private fun finalizePomorodo() {
        // repository.savePomorodo()
    }


}