package com.example.tasktimerapp

import android.os.Bundle
import android.util.EventLogTags
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

class AddTaskFragment : Fragment() {
    private val TaskModel by lazy { ViewModelProvider(this).get( TaskViewModel ::class.java) }

    lateinit var etTask: EditText
    lateinit var etDescription: EditText
    lateinit var btnSave: Button
    lateinit var btnback: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)
        etTask = view.findViewById(R.id.etName)
        etDescription = view.findViewById<EditText>(R.id.etDescription)
        btnback = view.findViewById(R.id.imgBtnBack1)
        btnSave = view.findViewById(R.id.btnSave)
            btnSave.setOnClickListener {

            val task = etTask.text.toString()
            val description = etDescription.text.toString()

            if (task.isNotEmpty() && description.isNotEmpty()) {
                TaskModel.addTask(Tasks(0, task, description, "00:00:00"))
                Toast.makeText(requireContext(), "data saved successfully!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "one or two fields are empty", Toast.LENGTH_SHORT).show()
            }
                etTask.text.clear()
                etTask.clearFocus()
                etDescription.text.clear()
                etDescription.clearFocus()
        }

        btnback.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_addTaskFragment_to_homeFragment)
        }

        return view
    }
}