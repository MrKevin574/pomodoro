package com.mrkevin574.pomodoro.domain

import com.mrkevin574.pomodoro.util.Cycles

data class Pomodoro(
    val name : String = "",
    val actualTimeRunning : Long = 0,
    val jobTime : Long = 0,
    val shortBreak : Float = 0f,
    val longBreak : Float = 0f,
    var actualCycle : Cycles = Cycles.FIRST,
    var isRunning : Boolean = false
)