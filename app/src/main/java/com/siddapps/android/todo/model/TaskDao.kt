package com.siddapps.android.todo.model

import android.arch.persistence.room.*

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAllTasks(): List<Task>

    @Query("SELECT * FROM tasks WHERE id IS :id")
    fun getTaskById(id: Int): Task

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun InsertTask(task: Task)

    @Update
    fun updateTasks(onConflict: Int = OnConflictStrategy.REPLACE)

    @Delete
    fun deleteTask(task: Task)
}