package com.siddapps.android.todo.ui.addtask

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.*
import com.siddapps.android.todo.R
import com.siddapps.android.todo.R.id.task_description
import kotlinx.android.synthetic.main.activity_add_task.*
import java.util.*

class AddTaskActivity : AppCompatActivity(), AddTaskView {
    var TAG = "AddTaskActivity"
    private val presenter: AddTaskPresenter = AddTaskPresenterImpl()

    companion object {

        fun newIntent(context: Context) = Intent(context, AddTaskActivity::class.java)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_task, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.save_task -> {
                presenter.saveTask(description = task_description.text.toString(), date = 0, isComplete = false)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        presenter.setView(this)
    }

    override fun finishActivity() {
        finish()
    }

}