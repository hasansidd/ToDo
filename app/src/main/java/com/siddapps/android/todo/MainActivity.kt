package com.siddapps.android.todo

import android.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.add_task -> {
                val fragment = AddTaskFragment.newFragment(10)
                supportFragmentManager
                        .beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .addToBackStack("test")
                        .commit()
                return true
            }
            R.id.settings -> {
                Log.i(TAG, "settings")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
