package com.siddapps.android.todo.application

import android.app.Application
import com.siddapps.android.todo.dagger.AppComponent
import com.siddapps.android.todo.dagger.AppModule

class TaskApplication : Application() {

    lateinit var taskComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
    }

    private fun initDagger(app:TaskApplication): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()
}