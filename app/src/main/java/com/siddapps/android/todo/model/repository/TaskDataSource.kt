package com.siddapps.android.todo.model.repository

import com.siddapps.android.todo.model.Task
import com.siddapps.android.todo.model.database.TaskDao

class TaskDataSource(val taskDao: TaskDao) :TaskRepository {

    override fun getAllTask()= taskDao.getAllTasks()

    override fun getTaskById(id: Int) = taskDao.getTaskById(id)

    override fun insertTask(task: Task) = taskDao.insertTask(task)

    override fun updateTask(task: Task) = taskDao.updateTask(task)

    override fun deleteTask(task: Task) = taskDao.deleteTask(task)
}