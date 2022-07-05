package com.mrkevin574.pomodoro.di

import android.app.Application
import androidx.room.Room
import com.mrkevin574.pomodoro.data.local.PomodoroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PomodoroModule {

    @Provides
    @Singleton
    fun provideDatabase(app : Application) : PomodoroDatabase
    {
        return Room.databaseBuilder(app, PomodoroDatabase::class.java, "MY_DATABASE").build()
    }

    @Provides
    @Singleton
    fun provideDao(db : PomodoroDatabase) = db.pomodoroDao()

}