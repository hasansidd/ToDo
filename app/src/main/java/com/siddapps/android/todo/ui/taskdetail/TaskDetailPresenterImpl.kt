package com.siddapps.android.todo.ui.taskdetail

import com.siddapps.android.todo.model.Task
import com.siddapps.android.todo.model.repository.TaskRepository
import javax.inject.Inject

class TaskDetailPresenterImpl @Inject constructor(private val taskRepository: TaskRepository) : TaskDetailPresenter {
    private lateinit var taskDetailView: TaskDetailView
    private lateinit var task: Task

    override fun setView(taskDetailView: TaskDetailView) {
        this.taskDetailView = taskDetailView
    }

    override fun loadTask(id: Int) {
        task = taskRepository.getTaskById(id)
        taskDetailView.showTask(task)
    }

    override fun saveTask(notes: String) {
        task.notes = notes
        taskRepository.updateTask(task)
        taskDetailView.finishActivity()
    }

    override fun deleteTask() {
        taskRepository.deleteTask(task)
        taskDetailView.finishActivity()
    }
}