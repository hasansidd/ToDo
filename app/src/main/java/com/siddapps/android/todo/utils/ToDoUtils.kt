package com.siddapps.android.todo.utils

import android.support.v4.app.Fragment
import com.siddapps.android.todo.R
import java.text.SimpleDateFormat
import java.util.*

class ToDoUtils {
    companion object {
        fun formatDate(date: Date): String {
            val sdf = SimpleDateFormat("EEEE hh:mm a")
            return sdf.format(date)
        }
    }
}