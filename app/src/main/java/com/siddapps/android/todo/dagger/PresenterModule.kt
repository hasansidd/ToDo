package com.siddapps.android.todo.dagger

import com.siddapps.android.todo.model.repository.TaskDataSource
import com.siddapps.android.todo.model.repository.TaskRepository
import com.siddapps.android.todo.ui.addtask.AddTaskPresenter
import com.siddapps.android.todo.ui.addtask.AddTaskPresenterImpl
import com.siddapps.android.todo.ui.homepage.HomepagePresenter
import com.siddapps.android.todo.ui.homepage.HomepagePresenterImpl
import com.siddapps.android.todo.ui.homepage.taskadapter.TaskAdapterPresenter
import com.siddapps.android.todo.ui.homepage.taskadapter.TaskAdapterPresenterImpl
import com.siddapps.android.todo.ui.taskdetail.TaskDetailPresenter
import com.siddapps.android.todo.ui.taskdetail.TaskDetailPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @Provides
    @Singleton
    fun provideHomepagePresenter(taskRepository: TaskRepository): HomepagePresenter = HomepagePresenterImpl(taskRepository)

    @Provides
    @Singleton
    fun provideAddTaskPresenter(taskRepository: TaskRepository): AddTaskPresenter = AddTaskPresenterImpl(taskRepository)

    @Provides
    @Singleton
    fun provideTaskDetailPresenter(taskRepository: TaskRepository): TaskDetailPresenter = TaskDetailPresenterImpl(taskRepository)

    @Provides
    @Singleton
    fun provideTaskAdapterPresenter(taskRepository: TaskRepository) : TaskAdapterPresenter = TaskAdapterPresenterImpl(taskRepository)
}