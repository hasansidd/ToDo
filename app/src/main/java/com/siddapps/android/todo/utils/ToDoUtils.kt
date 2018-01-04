package com.siddapps.android.todo.utils

import android.text.format.DateUtils
import java.util.*

class ToDoUtils {
    companion object {
        fun formatDate(date: Date): String {
            val timeInMillis:Long = date.time
            val formattedDate:CharSequence = DateUtils.getRelativeTimeSpanString(timeInMillis, Calendar.getInstance().timeInMillis, DateUtils.DAY_IN_MILLIS)
            return formattedDate.toString()
        }
    }
}