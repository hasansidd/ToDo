package com.siddapps.android.todo.ui.homepage

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.siddapps.android.todo.R
import com.siddapps.android.todo.model.Task
import com.siddapps.android.todo.utils.ToDoUtils

class TaskAdapter(private val context: Context, private val tasks: MutableList<Task>) : RecyclerView.Adapter<TaskAdapter.TaskHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            TaskHolder(LayoutInflater.from(context).inflate(R.layout.item_task_list, parent, false))

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TaskHolder?, position: Int) {
        holder?.let {
            it.taskTitle.text = tasks[position].description
            it.taskDate.text = ToDoUtils.formatDate(tasks[position].date)
            when (tasks[position].isComplete) {
                true -> it.taskComplete.visibility = View.VISIBLE
                false -> it.taskComplete.visibility = View.GONE
            }
        }
    }

    class TaskHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskTitle: TextView = view.findViewById(R.id.task_description)
        val taskDate: TextView = view.findViewById(R.id.task_date)
        val taskComplete: ImageView = view.findViewById(R.id.task_is_complete)
    }
}