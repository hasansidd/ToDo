package com.siddapps.android.todo.ui.taskdetail

import com.siddapps.android.todo.model.Task

interface TaskDetailPresenter {

    fun setView(taskDetailView: TaskDetailView)

    fun loadTask(id: Int)
}