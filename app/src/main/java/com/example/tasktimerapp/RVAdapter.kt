package com.example.tasktimerapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_task.view.*

class RVAdapter (private val Fragment: ViewTaskFragment): RecyclerView.Adapter<RVAdapter.MessageViewHolder>() {
    private var taskList: List<Tasks> = listOf()

    class MessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.MessageViewHolder {
        return RVAdapter.MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_task,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RVAdapter.MessageViewHolder, position: Int) {
        val aTask = taskList[position]

        holder.itemView.apply {
            tvTitle.text = aTask.task
            tvDescription.text = aTask.description
            etTime.setOnClickListener {
                // call Function Time()
            }
        }
    }

    override fun getItemCount() = taskList.size

    fun rvChange(tasks: List<Tasks>){
        this.taskList = tasks
        notifyDataSetChanged()
    }
}