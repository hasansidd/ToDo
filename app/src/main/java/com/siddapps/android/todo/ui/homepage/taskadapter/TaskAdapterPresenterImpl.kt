package com.siddapps.android.todo.ui.homepage.taskadapter

import com.siddapps.android.todo.model.Task
import com.siddapps.android.todo.model.repository.TaskRepository
import javax.inject.Inject

class TaskAdapterPresenterImpl @Inject constructor(private val taskRepository: TaskRepository) : TaskAdapterPresenter {
    private lateinit var taskAdapterView: TaskAdapterView

    override fun setView(taskAdapterView: TaskAdapterView) {
        this.taskAdapterView = taskAdapterView
    }

    override fun getTasks() =
            taskRepository.getAllTask()

    override fun deleteTask(task: Task) {
        taskRepository.deleteTask(task)
    }

    override fun getTaskItemCount() =
            getTasks().size

    override fun onBindViewHolder(position: Int, taskAdapterView: TaskAdapterView) {
        val task = getTasks()[position]
        taskAdapterView.setTitle(task.description)
        taskAdapterView.setDate(task.date)
        taskAdapterView.setPriority(task.priority)
    }

    override fun onItemClick(adapterPosition: Int) {
        val task = getTasks()[adapterPosition]
        taskAdapterView.navigateToTaskDetailActivity(task)
    }
}