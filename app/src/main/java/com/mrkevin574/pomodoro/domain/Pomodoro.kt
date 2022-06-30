package com.mrkevin574.pomodoro.domain

import java.util.*

data class Pomodoro(
    val name : String,
    val date : Date,
    val cycles : String,
    val focusedTime : Float
    )
