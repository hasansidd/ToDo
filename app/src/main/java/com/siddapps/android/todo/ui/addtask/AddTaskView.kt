package com.siddapps.android.todo.ui.addtask

import java.util.*

interface AddTaskView {

    fun finishActivity()

    fun setDueDate(timeInMillis: Date)
}