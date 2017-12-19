package com.siddapps.android.todo.ui.addtask

import android.util.Log
import android.widget.Toast
import com.siddapps.android.todo.model.Task
import com.siddapps.android.todo.model.repository.TaskDataSource
import com.siddapps.android.todo.model.repository.TaskRepository
import java.util.*
import javax.inject.Inject

class AddTaskPresenterImpl @Inject constructor(private val taskRepository: TaskRepository) : AddTaskPresenter {
    private val TAG = "AddTaskPresenterImpl"
    private lateinit var addTaskView: AddTaskView
    @Inject

    override fun setView(addTaskView: AddTaskView) {
        this.addTaskView = addTaskView
    }

    override fun saveTask(id: Int, description: String, date: Date, isComplete: Boolean) {
        val task = Task(id, description, date, isComplete)
        //add task to db
        taskRepository.insertTask(task)
        Log.e(TAG, task.toString())

        addTaskView.finishActivity()
    }
}