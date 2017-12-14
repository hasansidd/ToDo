package com.siddapps.android.todo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.siddapps.android.todo.model.AppDatabase
import com.siddapps.android.todo.ui.homepage.HomepageActivity

class AddTaskFragment : Fragment() {
    var TAG = "AddTaskFragment"

    companion object {
        private val EXTRA_TASK_ID = "extra_task_id"

        fun newFragment(id: Int) : Fragment{
            val args: Bundle = Bundle()
            args.putSerializable(EXTRA_TASK_ID, id)
            val fragment = AddTaskFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_add_task, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.add_task -> {
                val db = AppDatabase.getInstance(HomepageActivity.this)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_add_task,container,false)
        return v
    }
}