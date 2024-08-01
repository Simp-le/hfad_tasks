package com.hfad.tasks.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.tasks.model.Task
import com.hfad.tasks.model.TaskDao
import kotlinx.coroutines.launch

class TasksViewModel(private val dao: TaskDao): ViewModel() {
    var newTaskName = ""
    private val _navigateToTask = MutableLiveData<Long?>()
    val navigateToTask: LiveData<Long?>
        get() = _navigateToTask

    val tasks = dao.getAll()

    fun addTask() {
        viewModelScope.launch {
            dao.insert(Task(taskName = newTaskName))
        }
    }

    fun onTaskClicked(taskId: Long) {
        _navigateToTask.value = taskId
    }

    fun onTaskNavigated() {
        _navigateToTask.value = null
    }
}