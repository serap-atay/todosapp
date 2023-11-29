package com.example.todosapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.todosapp.data.repository.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoDetailViewModel :ViewModel() {

    val taskRepository = TaskRepository()
     fun buttonUpdate(taskid : String ,taskname:String,taskdescription :String,taskdate:String,tastime:String){
         CoroutineScope(Dispatchers.Main).launch {
          taskRepository.buttonUpdate(taskid,taskname,taskdescription,taskdate,tastime)
         }
     }
}