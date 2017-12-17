package com.siddapps.android.todo.ui.homepage

import com.siddapps.android.todo.model.Task
import java.util.*

class HomepagePresenterImpl : HomepagePresenter {
    private lateinit var homepageView: HomepageView

    override fun setView(homepageView: HomepageView) {
        this.homepageView = homepageView
    }

    override fun getTasks() {
        var tasks: MutableList<Task> = mutableListOf<Task>()
        tasks.add(Task(0, "Take trash out", Date(), false))
        tasks.add(Task(1, "Eat food", Date(), true))

        homepageView.displayTasks(tasks)
    }
}