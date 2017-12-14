package com.siddapps.android.todo.ui.homepage

import com.siddapps.android.todo.model.Task

interface HomepageView {
    fun displayTasks(tasks: MutableList<Task>)
}