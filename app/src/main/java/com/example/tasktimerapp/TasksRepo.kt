package com.example.tasktimerapp

import androidx.lifecycle.LiveData



class TasksRepo (private val tasksDao: TasksDao) {

    val Tasks: LiveData<List<Tasks>> = tasksDao.getAllTasks()

    fun addTask(task: Tasks){
        tasksDao.insertTask(task)
    }

    fun updateTask(task: Tasks){
        tasksDao.updateTask(task)
    }

    fun deleteTask(task: Tasks){
        tasksDao.deleteTask(task)
    }

}