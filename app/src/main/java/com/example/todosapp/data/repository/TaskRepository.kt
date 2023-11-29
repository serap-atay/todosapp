package com.example.todosapp.data.repository

import android.util.Log
import com.example.todosapp.data.datasource.TaskDataSource
import com.example.todosapp.data.entity.TaskModel

class TaskRepository {

    val taskDataSource = TaskDataSource()

    suspend fun  buttonSave (taskname:String,taskdescription :String,taskdate:String,tastime:String) = taskDataSource.buttonSave(taskname,taskdescription,taskdate,tastime)

    suspend fun buttonUpdate(taskid : String ,taskname:String,taskdescription :String,taskdate:String,tastime:String) = taskDataSource.buttonUpdate(taskid,taskname,taskdescription,taskdate,tastime)

    suspend fun buttonDelete(taskid : String ) = taskDataSource.buttonDelete(taskid)

    suspend fun  getTasks():List<TaskModel> = taskDataSource.getTasks()

    suspend fun search (taskName : String) :List<TaskModel> = taskDataSource.search(taskName)
}