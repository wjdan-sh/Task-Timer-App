package com.example.tasktimerapp

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation


class HomeFragment : Fragment() {
    lateinit var tvInstruction: TextView
    lateinit var btnAdd : Button
    lateinit var btnView: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        tvInstruction = view.findViewById(R.id.tvInstruction)
        tvInstruction.setOnClickListener{
            showInstructions()
        }
           btnAdd = view.findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_addTaskFragment)
        }
        btnView = view.findViewById(R.id.btnView)
            btnView.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_viewTaskFragment)
        }
        return view
    }
    fun showInstructions(){
        val customDialog = Dialog(requireContext())
        customDialog.setContentView(R.layout.instruction_dialog)
        customDialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        var ivSteps = customDialog.findViewById<ImageView>(R.id.ivSteps)
        var btnSkip = customDialog.findViewById<Button>(R.id.btnSkip)
        var btnNext = customDialog.findViewById<Button>(R.id.btnNext)
        btnSkip.setOnClickListener {
            customDialog.cancel()
        }
        var i = 0
        btnNext.setOnClickListener {
            when (i){
                0 -> ivSteps.setImageResource(R.drawable.step_2)
                1 -> ivSteps.setImageResource(R.drawable.step_3)
                else -> customDialog.cancel()
            }
            i ++
         }
        customDialog.show()
    }
}