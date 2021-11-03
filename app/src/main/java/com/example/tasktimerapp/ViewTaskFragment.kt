package com.example.tasktimerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ViewTaskFragment : Fragment() {
    lateinit var rvTasks: RecyclerView
    lateinit var taskList: ArrayList<String>
    lateinit var imgBtnBack: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_task, container, false)
        rvTasks.findViewById<RecyclerView>(R.id.rvTasks)
        taskList = arrayListOf()
        imgBtnBack.findViewById<ImageButton>(R.id.imgBtnBack)
        // call viewAllTasks()
        rvChange()
        return view
    }
    fun rvChange(){
        //taskList = TasksDatabase.getInstance(requireContext()).NotesDao().getAllNotesInfo()
        rvTasks.adapter = RVtasks(requireContext() as MainActivity, taskList)
        rvTasks.layoutManager = LinearLayoutManager(requireContext())
    }
}