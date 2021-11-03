package com.example.tasktimerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AddTaskFragment : Fragment() {
    lateinit var etName: EditText
    lateinit var etDescription: EditText
    lateinit var btnSave: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)
        etName.findViewById<EditText>(R.id.etName)
        etDescription.findViewById<EditText>(R.id.etDescription)
        btnSave.findViewById<Button>(R.id.btnSave).setOnClickListener {
            // call AddTask()
        }
        return view
    }
}