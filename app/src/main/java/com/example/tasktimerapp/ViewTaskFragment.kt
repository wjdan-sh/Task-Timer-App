package com.example.tasktimerapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktimerapp.Room.Tasks

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
        imgBtnBack= view.findViewById(R.id.imgBtnBack)
        TaskModel.getTasks().observe(viewLifecycleOwner,{
                notes -> Rvadapter.rvChange(notes)
        })

        rvTasks = view.findViewById(R.id.rvTasks)
        Rvadapter = RVAdapter(this)
        rvTasks.adapter = Rvadapter
        rvTasks.layoutManager = GridLayoutManager(requireContext(),2)

        imgBtnBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_viewTaskFragment_to_homeFragment)
        }

        return view
    }

    fun updateTaskTime(Task : Tasks, time:String){
        TaskModel.updateTask(Task.id,Task.task,Task.description,time)
    }

    fun deleteTask(Task : Tasks){
        val dialogBuilder = AlertDialog.Builder(requireContext())
        dialogBuilder
            .setCancelable(false)
            .setPositiveButton("yes", DialogInterface.OnClickListener {

                    dialog, id -> TaskModel.deleteTask(Task)

            })
            .setNegativeButton("No", DialogInterface.OnClickListener {

                    dialog, id -> dialog.cancel()

            })

        val alert = dialogBuilder.create()
        alert.setTitle("Are you sure want to delete?")
        alert.show()

    }
    }




