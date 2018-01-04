package com.siddapps.android.todo.ui.addtask

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.format.DateUtils
import android.text.format.DateUtils.DAY_IN_MILLIS
import android.view.*
import android.widget.DatePicker
import com.siddapps.android.todo.R
import com.siddapps.android.todo.application.TaskApplication
import com.siddapps.android.todo.utils.ToDoUtils
import kotlinx.android.synthetic.main.activity_add_task.*
import java.util.*
import javax.inject.Inject

class AddTaskActivity : AppCompatActivity(), AddTaskView, DatePickerDialog.OnDateSetListener {
    var TAG = "AddTaskActivity"

    @Inject
    lateinit var presenter: AddTaskPresenter
    private var date: Date = Date()

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
                presenter.saveTask(description = task_description.text.toString(), date = date,  isComplete = false)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        (application as TaskApplication).taskComponent.inject(this)
        presenter.setView(this)
        due_date_date.setOnClickListener({
            val fm = supportFragmentManager
            val datePickerFragment = DatePickerFragment()
            datePickerFragment.show(fm, "datepicker")
        })
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        //Set to noon on the selected day
        val c = Calendar.getInstance()
        c.set(Calendar.YEAR, year)
        c.set(Calendar.MONTH, month)
        c.set(Calendar.DAY_OF_MONTH, day)
        c.set(Calendar.HOUR_OF_DAY, 12)
        c.set(Calendar.MINUTE, 0)
        c.set(Calendar.SECOND, 0)

        setDueDate(c.time)
    }

    override fun setDueDate(date: Date) {
        this.date = date
        due_date_date.text = ToDoUtils.formatDate(date)
    }

    override fun finishActivity() {
        finish()
    }

}