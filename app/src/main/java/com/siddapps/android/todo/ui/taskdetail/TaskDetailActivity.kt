package com.siddapps.android.todo.ui.taskdetail

import android.content.Context
import android.content.Intent
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

    companion object {
        val ID_EXTRA: String = "id_extra"
        fun newIntent(context: Context, id: Int) : Intent {
            val i = Intent(context, TaskDetailActivity::class.java)
            i.putExtra(ID_EXTRA, id)
            return i
        }
    }

    @Inject
    lateinit var presenter: TaskDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)
        (application as TaskApplication).taskComponent.inject(this)

        presenter.setView(this)
        val id = intent.getIntExtra(ID_EXTRA,-1)
        presenter.loadTask(id)
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