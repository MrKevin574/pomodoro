package com.mrkevin574.pomodoro.domain

import com.mrkevin574.pomodoro.util.Cycles

data class Pomodoro(
    val name : String,
    val jobTime : Float,
    val shortBreak : Float,
    val longBreak : Float,
    var actualCycle : Cycles = Cycles.FIRST,
    var isRunning : Boolean = false
)