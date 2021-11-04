package com.example.tasktimerapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tasktimerapp.Room.Tasks
import com.example.tasktimerapp.Room.TasksDao


@Database(entities = [Tasks::class],version = 1,exportSchema = false)
abstract class TasksDatabase: RoomDatabase() {

    companion object{
        var instance:TasksDatabase?=null
        fun getInstance(ctx: Context):TasksDatabase
        {
            if(instance!=null)
            {
                return  instance as TasksDatabase
            }
            instance= Room.databaseBuilder(ctx,TasksDatabase::class.java,"Task").run { allowMainThreadQueries() }.build();
            return instance as TasksDatabase
        }
    }
    abstract fun TasksDao(): TasksDao
}