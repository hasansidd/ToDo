package com.siddapps.android.todo.ui.taskdetail

interface TaskDetailPresenter {

    fun setView(taskDetailView: TaskDetailView)

    fun loadTask(id: Int)

    fun saveTask(notes: String)

    fun deleteTask()
}