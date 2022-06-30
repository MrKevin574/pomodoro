package com.mrkevin574.pomodoro.domain

import java.util.*

data class PomodoroFinalized(
    val name : String,
    val date : Date,
    val cycles : Int,
    val focusedTime : Float
    )
