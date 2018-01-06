package com.siddapps.android.todo.ui.taskdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.siddapps.android.todo.R
import com.siddapps.android.todo.application.TaskApplication
import com.siddapps.android.todo.model.Task
import com.siddapps.android.todo.utils.ToDoUtils
import kotlinx.android.synthetic.main.activity_add_task.*
import kotlinx.android.synthetic.main.activity_task_detail.*
import kotlinx.android.synthetic.main.item_task_list.*
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_task_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.save_task -> {
                presenter.saveTask(notes = detail_task_notes.text.toString()
                )
            }
            R.id.delete_task -> {
                presenter.deleteTask()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)
        (application as TaskApplication).taskComponent.inject(this)

        presenter.setView(this)
        val id = intent.getIntExtra(ID_EXTRA,-1)
        presenter.loadTask(id)
    }

    override fun showTask(task: Task) {
        detail_task_description.text = task.description
        detail_task_date.text = ToDoUtils.formatDate(task.date)

        when (task.isPriority) {
            true -> detail_task_is_priority.visibility = View.VISIBLE
            false -> detail_task_is_priority.visibility = View.GONE
        }

        detail_task_notes.setText(task.notes, TextView.BufferType.EDITABLE)
    }

    override fun finishActivity() {
        finish()
    }
}