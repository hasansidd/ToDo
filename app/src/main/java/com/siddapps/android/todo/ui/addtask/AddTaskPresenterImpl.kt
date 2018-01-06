package com.siddapps.android.todo.ui.addtask

import android.support.v4.app.FragmentManager
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
    private lateinit var date: Date

    override fun setView(addTaskView: AddTaskView) {
        this.addTaskView = addTaskView
    }

    override fun saveTask(id: Int, description: String, date: Date, isPriority: Boolean, isComplete: Boolean, notes: String) {
        val task = Task(
                id = id,
                description = description,
                date = date,
                isPriority = isPriority,
                isComplete = isComplete,
                notes = notes
        )
        //add task to db
        taskRepository.insertTask(task)
        Log.e(TAG, task.toString())

        addTaskView.finishActivity()
    }
}
