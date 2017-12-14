package com.siddapps.android.todo.ui.homepage

interface HomepagePresenter {

    fun setView(homepageView: HomepageView)

    fun getTasks()
}