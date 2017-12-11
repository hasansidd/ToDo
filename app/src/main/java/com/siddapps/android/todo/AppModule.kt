package com.siddapps.android.todo

import android.arch.persistence.room.Room
import android.content.Context
import com.siddapps.android.todo.model.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    fun providesContext() = context

    @Singleton
    @Provides
    fun providesAppDatabase(context: Context) : AppDatabase =
            Room.databaseBuilder(context,AppDatabase::class.java, "tasks").allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun providesTasksDao(database: AppDatabase) = database.taskDao()

}