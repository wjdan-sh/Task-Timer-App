package com.example.tasktimerapp.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Tasks")
data class Tasks (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id : Int = 0, // this is how can include id if needed
    @ColumnInfo(name = "Task") val task: String,
    @ColumnInfo(name = "Description") val description: String,
    @ColumnInfo(name = "Time") val time: String


)
