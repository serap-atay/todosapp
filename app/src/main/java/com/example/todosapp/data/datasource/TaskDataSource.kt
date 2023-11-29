package com.example.todosapp.data.datasource

import android.util.Log
import com.example.todosapp.data.entity.TaskModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TaskDataSource {

    suspend fun  getTasks():List<TaskModel> =
        withContext(Dispatchers.IO) {
            val tasks = ArrayList<TaskModel>()
            val t1 =TaskModel("1","Do cook","Prepare dinner","12/10/2023","15:43")
            val t2 =TaskModel("2","Do exercise ","Do exercise ","02/10/2023","12:43")
            val t3 =TaskModel("3","Do shopping","Prepare a shopping list","16/10/2023","10:43")
            tasks.add(t1)
            tasks.add(t2)
            tasks.add(t3)
            return@withContext tasks
        }

    suspend fun search (taskName : String) :List<TaskModel> =
        withContext(Dispatchers.IO) {
            val tasks = ArrayList<TaskModel>()
            val t3 =TaskModel("3","Alışveriş yap","Alışveriş listesi hazırla","16/10/2023","10:43")
            tasks.add(t3)
            return@withContext tasks
        }

    suspend fun  buttonSave (taskname:String,taskdescription :String,taskdate:String,tastime:String){
    Log.e("buttonSave", "$taskname $taskdescription $taskdate $tastime")
    }

    suspend fun buttonUpdate(taskid : String ,taskname:String,taskdescription :String,taskdate:String,tastime:String) {
        Log.e("buttonUpdate", " $taskid $taskname $taskdescription $taskdate $tastime")
    }

    suspend fun buttonDelete(taskid : String ) {
        Log.e("buttonUpdate", " $taskid")
    }
}