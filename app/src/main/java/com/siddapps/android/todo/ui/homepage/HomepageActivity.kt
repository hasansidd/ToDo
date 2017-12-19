package com.siddapps.android.todo.ui.homepage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.*
import com.siddapps.android.todo.R
import com.siddapps.android.todo.application.TaskApplication
import com.siddapps.android.todo.model.Task
import com.siddapps.android.todo.ui.addtask.AddTaskActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class HomepageActivity : AppCompatActivity(), HomepageView {
    private val TAG = "HomepageActivity"

    @Inject
    lateinit var presenter: HomepagePresenter

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.add_task -> {
                startActivity(AddTaskActivity.newIntent(this))
                return true
            }
            R.id.settings -> {
                Log.i(TAG, "settings")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as TaskApplication).taskComponent.inject(this)

        task_list_rv.layoutManager = LinearLayoutManager(this)

        presenter.setView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.getTasks()
    }

    override fun displayTasks(tasks: List<Task>) {
        task_list_rv.adapter = TaskAdapter(this, tasks)
    }


}
