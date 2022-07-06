package com.mrkevin574.pomodoro.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PomodoroDao {
    @Insert
    suspend fun savePomodoro(pomodoroEntity: PomodoroEntity)

    @Query("SELECT * FROM PomodoroEntity ORDER BY id DESC")
    suspend fun getAllPomodoro() : List<PomodoroEntity>

    @Delete
    suspend fun deletePomodoro(pomodoroEntity: PomodoroEntity)
}