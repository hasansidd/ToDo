package com.siddapps.android.todo.ui.taskdetail

import com.siddapps.android.todo.model.Task
import com.siddapps.android.todo.model.repository.TaskRepository
import javax.inject.Inject

class TaskDetailPresenterImpl @Inject constructor(private val taskRepository: TaskRepository) : TaskDetailPresenter {
    private lateinit var taskDetailView: TaskDetailView

    override fun setView(taskDetailView: TaskDetailView) {
        this.taskDetailView = taskDetailView
    }

    override fun loadTask(id: Int) {
        val task = taskRepository.getTaskById(id)
        taskDetailView.showTask(task)
    }
}