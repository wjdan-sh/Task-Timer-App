package com.example.tasktimerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    lateinit var btnAdd: Button
    lateinit var btnView: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        btnAdd.findViewById<Button>(R.id.btnAdd).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_addTaskFragment)
        }
        btnView.findViewById<Button>(R.id.btnView).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_viewTaskFragment)
        }
        return view
    }
}