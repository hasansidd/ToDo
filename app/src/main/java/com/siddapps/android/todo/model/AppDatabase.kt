package com.siddapps.android.todo.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(Task::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        fun getInstance(context:Context) = Room.databaseBuilder(context,AppDatabase::class.java,"tasks.db").build()
    }

}