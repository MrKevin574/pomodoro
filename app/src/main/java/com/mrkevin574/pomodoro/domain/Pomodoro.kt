package com.mrkevin574.pomodoro.domain

data class Pomodoro(
    val name : String,
    val jobTime : Float,
    val shortBreak : Float,
    val longBreak : Float,
    var actualCycle : Int = 0
)