package com.siddapps.android.todo.dagger

import com.siddapps.android.todo.ui.addtask.AddTaskPresenter
import com.siddapps.android.todo.ui.addtask.AddTaskPresenterImpl
import com.siddapps.android.todo.ui.homepage.HomepagePresenter
import com.siddapps.android.todo.ui.homepage.HomepagePresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @Provides
    @Singleton
    fun provideHomepagePresenter(): HomepagePresenter = HomepagePresenterImpl()

    @Provides
    @Singleton
    fun provideAddTaskPresenter():AddTaskPresenter = AddTaskPresenterImpl()
}