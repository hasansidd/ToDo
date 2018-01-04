package com.siddapps.android.todo.ui.homepage.taskadapter

import com.siddapps.android.todo.model.Task
import java.util.*

interface TaskAdapterView {

    fun setTitle(title:String)

    fun setDate(date:Date)

    fun setPriority(isPriority:Boolean)

    fun navigateToTaskDetailActivity(task: Task)
}