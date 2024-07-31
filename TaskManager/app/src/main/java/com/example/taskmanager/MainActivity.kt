package com.example.taskmanager

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, AddTaskFragment())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add_task -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AddTaskFragment())
                    .commit()
                true
            }
            R.id.action_view_tasks -> {
                val dialog = ViewTaskDialogFragment()
                dialog.show(supportFragmentManager, "ViewTaskDialogFragment")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
