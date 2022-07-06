package com.mrkevin574.pomodoro.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mrkevin574.pomodoro.domain.Pomodoro
import com.mrkevin574.pomodoro.util.Cycles
import java.util.*

@Entity
data class PomodoroEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "name")val name : String = "",
    @ColumnInfo(name = "date")val date : String = "",
    @ColumnInfo(name = "cycles")val cycles : Int = 0,
    @ColumnInfo(name = "focusedTime")val focusedTime : Long = 0
)

fun Pomodoro.toEntity(focusedTime: Long)  = PomodoroEntity(
    name = this.name,
    date = Date().toString(),
    cycles = when(this.actualCycle)
    {
        Cycles.FIRST -> 1
        Cycles.SHORT_BREAK -> 2
        Cycles.MEDIUM -> 3
        Cycles.LONG_BREAK -> 4
        Cycles.LAST -> 5
    },
    focusedTime = focusedTime / 60 / 1000
)
