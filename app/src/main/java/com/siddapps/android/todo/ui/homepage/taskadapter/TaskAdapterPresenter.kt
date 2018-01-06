package com.siddapps.android.todo.ui.homepage.taskadapter

import com.siddapps.android.todo.model.Task

interface TaskAdapterPresenter {

    fun setView(taskAdapterView: TaskAdapterView)

    fun getTasks(): List<Task>

    fun deleteTask(task: Int)

    fun getTaskItemCount(): Int

    fun onBindViewHolder(position: Int, taskAdapterView: TaskAdapterView)

    fun onItemClick(adapterPosition: Int)
}