package com.siddapps.android.todo.ui.homepage

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.siddapps.android.todo.R
import com.siddapps.android.todo.model.Task
import com.siddapps.android.todo.ui.taskdetail.TaskDetailActivity
import com.siddapps.android.todo.utils.ToDoUtils

class TaskAdapter(private val context: Context, private val tasks: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            TaskHolder(LayoutInflater.from(context).inflate(R.layout.item_task_list, parent, false))

    override fun getItemCount() =
            tasks.size

    override fun onBindViewHolder(holder: TaskHolder?, position: Int) =
            holder?.bind(tasks[position])!!

    class TaskHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private val taskTitle: TextView = view.findViewById(R.id.task_description)
        private val taskDate: TextView = view.findViewById(R.id.task_date)
        private val taskComplete: ImageView = view.findViewById(R.id.task_is_complete)
        private var task: Task? = null

        init {
            view.setOnClickListener(this)
        }

        fun bind(task: Task?) {
            this.task = task
            let {
                it.taskTitle.text = task?.description
                it.taskDate.text = ToDoUtils.formatDate(task!!.date)
                when (task!!.isComplete) {
                    true -> it.taskComplete.visibility = View.VISIBLE
                    false -> it.taskComplete.visibility = View.GONE
                }
            }
        }

        override fun onClick(v: View?) {
           val i= TaskDetailActivity.newIntent(v!!.context, task!!.id)
            Log.e("ViewHolder", task!!.id.toString())
            v.context.startActivity(i)
        }
    }
}