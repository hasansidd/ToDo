package com.siddapps.android.todo.ui.taskdetail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.siddapps.android.todo.R
import com.siddapps.android.todo.application.TaskApplication
import com.siddapps.android.todo.model.Task
import com.siddapps.android.todo.utils.ToDoUtils
import kotlinx.android.synthetic.main.activity_task_detail.*
import javax.inject.Inject

class TaskDetailActivity : AppCompatActivity(), TaskDetailView {

    @Inject
    lateinit var presenter: TaskDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        (application as TaskApplication).taskComponent.inject(this)
    }

    override fun showTask(task: Task) {
        task_description.text = task.description
        task_date.text = ToDoUtils.formatDate(task.date)

        when (task.isComplete) {
            true -> task_is_complete.visibility = View.VISIBLE
            false -> task_is_complete.visibility = View.GONE
        }
    }
}