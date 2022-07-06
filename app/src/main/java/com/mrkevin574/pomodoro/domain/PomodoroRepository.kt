package com.mrkevin574.pomodoro.domain

import androidx.compose.runtime.MutableState
import com.mrkevin574.pomodoro.data.local.PomodoroDao
import com.mrkevin574.pomodoro.data.local.PomodoroEntity
import com.mrkevin574.pomodoro.data.local.toEntity
import javax.inject.Inject

class PomodoroRepository @Inject constructor(private val dao : PomodoroDao)
{
    suspend fun savePomodoro(pomodoro: Pomodoro, focusedTime : Long)
    {
        dao.savePomodoro(pomodoro.toEntity(focusedTime))
    }

    suspend fun getAllPomodoro() : List<PomodoroEntity>
    {
        return dao.getAllPomodoro()
    }

    suspend fun deletePomodoro(pomodoro: PomodoroEntity)
    {
        dao.deletePomodoro(pomodoro)
    }
}