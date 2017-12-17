package com.siddapps.android.todo.model.database

import android.arch.persistence.room.TypeConverter
import java.util.*


class Converters{

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromTimeStamp(timeStamp: Long?): Date? {
        return if (timeStamp == null) null else Date(timeStamp)
    }
}