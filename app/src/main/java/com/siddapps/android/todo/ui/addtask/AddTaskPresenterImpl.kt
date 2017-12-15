package com.siddapps.android.todo.ui.addtask

import android.util.Log
import android.widget.Toast
import com.siddapps.android.todo.model.Task
import java.util.*

class AddTaskPresenterImpl : AddTaskPresenter {
    private lateinit var addTaskView:AddTaskView

    override fun setView(addTaskView: AddTaskView) {
        this.addTaskView = addTaskView
    }

    override fun saveTask(id: Int, description: String, date: Date, isComplete: Boolean) {
       val task = Task(id, description, date, isComplete)
        //add task to db
        Log.e("Added Task", description)
    }
}