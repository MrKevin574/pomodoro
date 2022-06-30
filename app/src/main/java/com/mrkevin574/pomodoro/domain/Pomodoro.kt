package com.mrkevin574.pomodoro.domain

import java.time.LocalDateTime
import java.util.*

data class Pomodoro(
    val name : String,
    val date : Date,
    val cycles : Int,
    val focusedTime : Float
    )
