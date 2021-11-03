package com.example.tasktimerapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TasksDao {

    @Query("SELECT * FROM Tasks ORDER BY id ")
    fun getAllTasks(): LiveData<List<Tasks>>

    @Insert
    fun insertTask(task: Tasks)

    @Update
    fun updateTask(task: Tasks)
    @Delete
    fun deleteTask(task: Tasks)

}