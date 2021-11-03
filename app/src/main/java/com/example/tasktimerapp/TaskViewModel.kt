package com.example.tasktimerapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel (applicationContext: Application) : AndroidViewModel(applicationContext) {

    private val repo:TasksRepo
    private val tasks : LiveData<List<Tasks>>

    init {
        val tasksDao = TasksDatabase.getInstance(applicationContext).TasksDao()
        repo = TasksRepo(tasksDao)
        tasks = repo.Tasks
    }

    fun getTasks() :LiveData<List<Tasks>>{
        return tasks
    }

    fun addTask(task: Tasks){
        CoroutineScope(Dispatchers.IO).launch {
            repo.addTask(task)
        }
    }

    fun updateTask( TaskID:Int , Task:String , Description:String ,Time:String){
        CoroutineScope(Dispatchers.IO).launch {
            repo.updateTask(Tasks(TaskID, Task,Description,Time))
        }
    }

    fun deleteTask(task: Tasks){
        CoroutineScope(Dispatchers.IO).launch {
            repo.deleteTask(task)
        }
    }

}