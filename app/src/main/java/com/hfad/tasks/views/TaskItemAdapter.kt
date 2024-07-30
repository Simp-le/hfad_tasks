package com.hfad.tasks.views

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.hfad.tasks.R
import com.hfad.tasks.model.Task

class TaskItemAdapter : RecyclerView.Adapter<TaskItemAdapter.TaskItemViewHolder>() {
    // This is for the recycler view's data
    var data = listOf<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // The number of items
    override fun getItemCount() = data.size

    // parent - recycler view. This gets called when a view holder needs to be created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder =
        TaskItemViewHolder.inflateFrom(parent)

    // holder is the view holder the method needs to add data to.
    // This gets called when data needs to be displayed in a view holder
    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    // This defined the view holder
    class TaskItemViewHolder(private val rootView: CardView) : RecyclerView.ViewHolder(rootView) {

        private val taskName = rootView.findViewById<TextView>(R.id.task_name)
        private val taskDone = rootView.findViewById<CheckBox>(R.id.task_done)

        // This adds data to the view holder's layout
        fun bind(item: Task) {
            taskName.text = item.taskName
            taskDone.isChecked = item.taskDone
        }

        // inflateFrom() method is in a companion object so it can be called without first creating a TaskItemViewHolder object
        companion object {
            // This creates each view holder and inflates its layout
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.task_item, parent, false) as CardView
                return TaskItemViewHolder(view)
            }
        }
    }
}