package com.hfad.tasks.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.hfad.tasks.model.Task
import com.hfad.tasks.model.TaskDao
import kotlinx.coroutines.launch

class TasksViewModel(private val dao: TaskDao): ViewModel() {
    var newTaskName = ""

    val tasks = dao.getAll()
    val tasksString = tasks.map {
        tasks -> formatTasks(tasks)
    }

    fun addTask() {
        viewModelScope.launch {
            dao.insert(Task(taskName = newTaskName))
        }
    }

    private fun formatTasks(tasks: List<Task>): String {
        return tasks.fold("") {
            str, item -> str + "\n" + formatTask(item)
        }
    }

    private fun formatTask(task: Task): String {
        return """
            ID: ${task.taskId}
            Name: ${task.taskName}
            Complete: ${task.taskDone}
            
        """.trimIndent()
    }
}