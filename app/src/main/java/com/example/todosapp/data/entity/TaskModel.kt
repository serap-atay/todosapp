package com.example.todosapp.data.entity

import java.io.Serializable

data class TaskModel(var taskId:String, var taskName:String, var taskDescription:String, var taskDate:String, var taskTime:String) :
    Serializable{

    }
