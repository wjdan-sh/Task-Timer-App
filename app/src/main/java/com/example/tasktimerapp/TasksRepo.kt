package com.example.tasktimerapp

import androidx.lifecycle.LiveData



class TasksRepo (private val tasksDao: TasksDao) {

    val Tasks: LiveData<List<Tasks>> = tasksDao.getAllTasks()

    fun addTask(note: Tasks){
        tasksDao.insertTask(note)
    }

}