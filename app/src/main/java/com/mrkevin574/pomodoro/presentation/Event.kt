package com.mrkevin574.pomodoro.presentation

sealed class Event{
    object Next : Event()
    object Stop : Event()
    object Resume : Event()
    object Play : Event()
    object Pause : Event()
}
