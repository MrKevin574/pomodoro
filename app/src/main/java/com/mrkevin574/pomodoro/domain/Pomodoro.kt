package com.mrkevin574.pomodoro.domain

data class Pomodoro(
    val name : String,
    val jobTime : Int,
    val shortBreak : Int,
    val longBreak : Int,
    var actualCycle : Int = 0
)