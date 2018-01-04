package com.siddapps.android.todo.ui.homepage

import com.siddapps.android.todo.model.repository.TaskRepository
import javax.inject.Inject

class HomepagePresenterImpl @Inject constructor(private val taskRepository: TaskRepository) : HomepagePresenter {
    private lateinit var homepageView: HomepageView

    override fun setView(homepageView: HomepageView) {
        this.homepageView = homepageView
    }

}