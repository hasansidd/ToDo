package com.siddapps.android.todo.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "tasks")
data class Task(@PrimaryKey(autoGenerate = true) val id: Int,
                var description: String,
                var date: Date,
                var isComplete: Boolean = false,
                var isPriority: Boolean = false,
                var notes: String) {

    override fun toString(): String {
        return ("ID: " + id.toString() + "\n" +
                "Title: " + description + "\n" +
                "Date: " + date + "\n" +
                "Priority: " + isPriority + "\n" +
                "Complete: " + isComplete + "\n" +
                "notes: " + notes)
    }
}
