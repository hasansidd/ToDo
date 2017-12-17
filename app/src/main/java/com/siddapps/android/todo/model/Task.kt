package com.siddapps.android.todo.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.siddapps.android.todo.utils.ToDoUtils
import java.util.*

@Entity(tableName = "tasks")
data class Task(@PrimaryKey(autoGenerate = true) val id: Int,
                var description: String,
                var date: Date,
                var isComplete: Boolean = false) {


    override fun toString(): String {
        return (id.toString() + " " +
                description + " "  +
                date + " " +
                isComplete)
    }
}
