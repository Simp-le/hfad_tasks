package com.hfad.tasks.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.tasks.model.Task
import com.hfad.tasks.model.TaskDao
import kotlinx.coroutines.launch

class TasksViewModel(private val dao: TaskDao): ViewModel() {
    var newTaskName = ""

    val tasks = dao.getAll()

    fun addTask() {
        viewModelScope.launch {
            dao.insert(Task(taskName = newTaskName))
        }
    }
}