package com.example.tasktimerapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktimerapp.databinding.ItemTaskBinding

class RVtasks(val activity: MainActivity, var taskList: List<String>): RecyclerView.Adapter<RVtasks.ItemViewHolder>() {
    class ItemViewHolder(var binding: ItemTaskBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val aTask = taskList[position]

        holder.binding.apply {
            tvTitle.text = aTask
            tvDescription.text = aTask
            etTime.setOnClickListener {
                // call Function Time()
            }
        }
}
    override fun getItemCount(): Int = taskList.size
}