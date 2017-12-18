package com.siddapps.android.todo.dagger

import android.arch.persistence.room.Room
import android.content.Context
import com.siddapps.android.todo.model.database.TaskDao
import com.siddapps.android.todo.model.database.TaskDatabase
import com.siddapps.android.todo.model.repository.TaskDataSource
import com.siddapps.android.todo.model.repository.TaskRepository
import com.siddapps.android.todo.utils.Const
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideTaskDb(context: Context): TaskDatabase {
        return Room.databaseBuilder(context, TaskDatabase::class.java, Const.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(taskDatabase: TaskDatabase): TaskDao {
        return taskDatabase.taskDao()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(taskDao: TaskDao): TaskRepository {
        return TaskDataSource(taskDao)
    }
}