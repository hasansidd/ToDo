package com.siddapps.android.todo.ui.homepage.taskadapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.siddapps.android.todo.R
import com.siddapps.android.todo.ui.taskdetail.TaskDetailActivity
import com.siddapps.android.todo.utils.ToDoUtils
import android.support.v7.app.AlertDialog
import com.siddapps.android.todo.model.Task
import java.util.*
import javax.inject.Inject


class TaskAdapter(private val context: Context) : RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    @Inject
    lateinit var presenter:TaskAdapterPresenter

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            TaskHolder(LayoutInflater.from(context).inflate(R.layout.item_task_list, parent, false), presenter)

    override fun getItemCount() =
            presenter.getTaskItemCount()

    override fun onBindViewHolder(holder: TaskHolder?, position: Int) =
            presenter.onBindViewHolder(position, holder!!)

    class TaskHolder(view: View, private val presenter: TaskAdapterPresenter) : RecyclerView.ViewHolder(view)
            , View.OnClickListener
            , View.OnLongClickListener
            , TaskAdapterView {

        private val taskTitle: TextView = view.findViewById(R.id.task_description)
        private val taskDate: TextView = view.findViewById(R.id.task_date)
        private val taskComplete: ImageView = view.findViewById(R.id.task_is_complete)

        init {
            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
        }

        override fun setTitle(title: String) {
            taskTitle.text = title
        }

        override fun setDate(date: Date) {
            taskDate.text = ToDoUtils.formatDate(date)
        }

        override fun setPriority(isPriority: Boolean) {
            when (isPriority) {
                true -> taskComplete.visibility = View.VISIBLE
                false -> taskComplete.visibility = View.GONE
            }
        }

        override fun onClick(v: View?) {
            presenter.onItemClick(adapterPosition)
        }

        override fun onLongClick(v: View?): Boolean {
            AlertDialog.Builder(v!!.context)
                    //set message, title, and icon
                    .setTitle("Delete")
                    .setMessage("Do you want to Delete")
                    .setIcon(R.drawable.ic_delete_black_24dp)
                    .setPositiveButton("Delete", { dialog, whichButton ->

                        dialog.dismiss()
                    })
                    .setNegativeButton("cancel", { dialog, which ->
                        dialog.dismiss()
                    })
                    .create()
                    .show()
            return true
        }

        override fun navigateToTaskDetailActivity(task: Task) {
            val i = TaskDetailActivity.newIntent(itemView.context, task.id)
            itemView.context.startActivity(i)
        }
    }
}