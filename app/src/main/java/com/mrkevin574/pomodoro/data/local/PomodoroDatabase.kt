package com.mrkevin574.pomodoro.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PomodoroEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PomodoroDatabase : RoomDatabase(){
    abstract fun pomodoroDao() : PomodoroDao
}