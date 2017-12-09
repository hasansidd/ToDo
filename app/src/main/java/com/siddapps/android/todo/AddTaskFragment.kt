package com.siddapps.android.todo

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class AddTaskFragment : Fragment() {

    companion object {
        private val EXTRA_TASK_ID = "extra_task_id"

        fun newFragment(id: Int) : AddTaskFragment{
            val args: Bundle = Bundle()
            args.putSerializable(EXTRA_TASK_ID, id)
            val fragment = AddTaskFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}