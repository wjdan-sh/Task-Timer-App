package com.example.tasktimerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ViewTaskFragment : Fragment() {
    private val TaskModel by lazy { ViewModelProvider(this).get( TaskViewModel ::class.java) }

    lateinit var rvTasks: RecyclerView
    private lateinit var Rvadapter: RVAdapter
    lateinit var taskList: ArrayList<String>
    lateinit var imgBtnBack: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_view_task, container, false)

        taskList = arrayListOf()
        imgBtnBack.findViewById<ImageButton>(R.id.imgBtnBack)
        TaskModel.getTasks().observe(viewLifecycleOwner,{
                notes -> Rvadapter.rvChange(notes)
        })

        rvTasks.findViewById<RecyclerView>(R.id.rvTasks)
        Rvadapter = RVAdapter(this)
        rvTasks.adapter = Rvadapter
        rvTasks.layoutManager = LinearLayoutManager(requireContext())

        imgBtnBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_viewTaskFragment_to_homeFragment)
        }

        return view
    }



}