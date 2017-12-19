package com.siddapps.android.todo.ui.taskdetail

import com.siddapps.android.todo.model.Task

interface TaskDetailView {
    fun showTask(task: Task)
}