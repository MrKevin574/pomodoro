package com.mrkevin574.pomodoro.domain

import com.mrkevin574.pomodoro.data.local.PomodoroDao
import com.mrkevin574.pomodoro.data.local.PomodoroEntity
import com.mrkevin574.pomodoro.data.local.toEntity
import javax.inject.Inject

class PomodoroRepository @Inject constructor(val dao : PomodoroDao)
{
    suspend fun savePomodoro(pomodoro: Pomodoro)
    {
        dao.savePomodoro(pomodoro.toEntity())
    }

    suspend fun getAllPomodoro() : List<PomodoroEntity>
    {
        return dao.getAllPomodoro()
    }
}