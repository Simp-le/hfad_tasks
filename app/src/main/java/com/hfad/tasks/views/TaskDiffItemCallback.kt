package com.hfad.tasks.views

import androidx.recyclerview.widget.DiffUtil
import com.hfad.tasks.model.Task

class TaskDiffItemCallback: DiffUtil.ItemCallback<Task>() {

    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean = (oldItem.taskId == newItem.taskId)

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean = (oldItem == newItem)

}