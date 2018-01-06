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
import android.util.Log
import com.siddapps.android.todo.model.Task
import java.util.*

class TaskAdapter(private val context: Context, private val presenter: TaskAdapterPresenter) : RecyclerView.Adapter<TaskAdapter.TaskHolder>(), RecyclerViewClickListener {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TaskHolder? {
        val v: View = LayoutInflater.from(context).inflate(R.layout.item_task_list, parent, false)
        val holder = TaskHolder(v, presenter)
        holder.setClickListener(this)
        return holder
    }

    override fun getItemCount() =
            presenter.getTaskItemCount()

    override fun onBindViewHolder(holder: TaskHolder?, position: Int) =
            presenter.onBindViewHolder(position, holder!!)

    override fun onTaskClicked() {
        notifyDataSetChanged()
    }

    class TaskHolder(view: View, private val presenter: TaskAdapterPresenter) : RecyclerView.ViewHolder(view)
            , View.OnClickListener
            , View.OnLongClickListener
            , TaskAdapterView {

        private val taskTitle: TextView = view.findViewById(R.id.task_description)
        private val taskDate: TextView = view.findViewById(R.id.task_date)
        private val taskIsPriority: ImageView = view.findViewById(R.id.task_is_priority)
        private lateinit var listener: RecyclerViewClickListener

        init {
            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
            presenter.setView(this)
        }

        override fun setClickListener(recyclerViewClickListener: RecyclerViewClickListener) {
            this.listener = recyclerViewClickListener
        }

        override fun setTitle(title: String) {
            taskTitle.text = title
        }

        override fun setDate(date: Date) {
            taskDate.text = ToDoUtils.formatDate(date)
        }

        override fun setPriority(isPriority: Boolean) {
            when (isPriority) {
                true -> taskIsPriority.visibility = View.VISIBLE
                false -> taskIsPriority.visibility = View.GONE
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
                        presenter.deleteTask(adapterPosition)
                        listener.onTaskClicked()
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