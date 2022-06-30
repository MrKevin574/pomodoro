package com.mrkevin574.pomodoro.domain

import com.mrkevin574.pomodoro.util.Cycles

data class Pomodoro(
    val name : String = "",
    val jobTime : Float = 0f,
    val shortBreak : Float = 0f,
    val longBreak : Float = 0f,
    var actualCycle : Cycles = Cycles.FIRST,
    var isRunning : Boolean = false
)