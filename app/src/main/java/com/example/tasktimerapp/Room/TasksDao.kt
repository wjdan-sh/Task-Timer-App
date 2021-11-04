package com.example.tasktimerapp.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tasktimerapp.Room.Tasks

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