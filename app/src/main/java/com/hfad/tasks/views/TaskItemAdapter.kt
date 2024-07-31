package com.hfad.tasks.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hfad.tasks.databinding.TaskItemBinding
import com.hfad.tasks.model.Task

class TaskItemAdapter : ListAdapter<Task, TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallback()) {
    // parent - recycler view. This gets called when a view holder needs to be created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder =
        TaskItemViewHolder.inflateFrom(parent)

    // holder is the view holder the method needs to add data to.
    // This gets called when data needs to be displayed in a view holder
    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    // This defined the view holder
    class TaskItemViewHolder(private val binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {
        // This binds Task object to its layout
        fun bind(item: Task) {
            binding.task = item
        }

        // inflateFrom() method is in a companion object so it can be called without first creating a TaskItemViewHolder object
        companion object {
            // This creates each view holder and inflates its layout
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
                return TaskItemViewHolder(binding)
            }
        }
    }
}