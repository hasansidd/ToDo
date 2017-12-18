package com.siddapps.android.todo.model.repository

import com.siddapps.android.todo.model.Task
import com.siddapps.android.todo.model.database.TaskDao

interface TaskRepository {

    fun getAllTask():List<Task>

    fun getTaskById(id:Int):Task

    fun insertTask(task: Task)

    fun updateTask(task: Task)

    fun deleteTask(task:Task)
}