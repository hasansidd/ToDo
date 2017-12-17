package com.siddapps.android.todo.dagger

import com.siddapps.android.todo.ui.addtask.AddTaskActivity
import com.siddapps.android.todo.ui.addtask.AddTaskPresenter
import com.siddapps.android.todo.ui.homepage.HomepageActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class, DatabaseModule::class])
interface AppComponent {

    fun inject(target: HomepageActivity)

    fun inject(target: AddTaskActivity)
}