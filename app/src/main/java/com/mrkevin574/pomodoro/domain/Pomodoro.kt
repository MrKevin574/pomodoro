package com.mrkevin574.pomodoro.domain

import com.mrkevin574.pomodoro.util.Cycles

data class Pomodoro(
    var name : String = "",
    var actualTimeRunning : Long = 0,
    val timeRunningInmutable : Long = 0,
    var jobTime : Long = 0,
    var shortBreak : Float = 0f,
    var longBreak : Float = 0f,
    var actualCycle : Cycles = Cycles.FIRST,
    var isRunning : Boolean = false
)