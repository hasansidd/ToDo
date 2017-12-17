package com.siddapps.android.todo.ui.addtask

import java.util.*

interface AddTaskPresenter {

    fun setView(addTaskView: AddTaskView)

    fun saveTask(id:Int = 0, description: String, date: Date, isComplete: Boolean)

}