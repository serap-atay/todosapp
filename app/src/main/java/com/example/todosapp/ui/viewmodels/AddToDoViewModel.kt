package com.example.todosapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.todosapp.data.repository.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddToDoViewModel : ViewModel() {

    val taskRepository = TaskRepository()

     fun  buttonSave (taskname:String,taskdescription :String,taskdate:String,tastime:String){
         CoroutineScope(Dispatchers.Main).launch {
             taskRepository.buttonSave(taskname,taskdescription,taskdate,tastime)
         }
     }

}