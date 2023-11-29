package com.example.todosapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todosapp.data.entity.TaskModel
import com.example.todosapp.data.repository.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    val taskRepository = TaskRepository()
    var tasklist =MutableLiveData<List<TaskModel>>()

     fun buttonDelete(taskid : String ){
         CoroutineScope(Dispatchers.Main).launch {
             taskRepository.buttonDelete(taskid)
             getTasks()
         }
     }
    init {
        getTasks()
    }
     fun  getTasks(){
         CoroutineScope(Dispatchers.Main).launch {
              tasklist.value = taskRepository.getTasks()
         }
     }

     fun search (taskName : String) {
         CoroutineScope(Dispatchers.Main).launch{
             tasklist.value = taskRepository.search(taskName)
         }
     }
}