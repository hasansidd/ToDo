package com.siddapps.android.todo.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.siddapps.android.todo.model.Task

@Database(entities = arrayOf(Task::class), version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}