package com.example.todosapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todosapp.R
import com.example.todosapp.data.entity.TaskModel
import com.example.todosapp.databinding.FragmentTodoDetailBinding
import com.example.todosapp.ui.viewmodels.AddToDoViewModel
import com.example.todosapp.ui.viewmodels.ToDoDetailViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.Locale

class TodoDetailFragment : Fragment() {
    private lateinit var binding: FragmentTodoDetailBinding
    private lateinit var toDoViewModel: ToDoDetailViewModel
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_todo_detail, container, false)
        binding.todoDetailFragment = this

        val bundle: TodoDetailFragmentArgs by navArgs()
        val task = bundle.todo
        binding.task = task

        binding.txtTaskName2.setText(task.taskName)
        binding.txtDescriptionMulti2.setText(task.taskDescription)
        binding.txtTaskDate2.setText(task.taskDate)
        binding.txtTaskTime2.setText(task.taskTime)

        binding.btnDate2.setOnClickListener {
            val dp = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Calender")
                .build()

            dp.addOnPositiveButtonClickListener {
                val df = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                binding.txtTaskDate2.setText(df.format(it).toString())
            }

            dp.show(requireActivity().supportFragmentManager, "Date")
        }

        binding.btnTime.setOnClickListener {
            val tp = MaterialTimePicker.Builder()
                .setTitleText("Time")
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build()

            tp.addOnPositiveButtonClickListener {
                binding.txtTaskTime2.setText("${tp.hour} : ${tp.minute}")
            }

            tp.show(requireActivity().supportFragmentManager, "Date")
        }
        binding.btnUpdate.setOnClickListener {
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : ToDoDetailViewModel by viewModels()
        toDoViewModel = tempViewModel
    }

    fun buttonUpdate(taskid : String ,taskname:String,taskdescription :String,taskdate:String,tastime:String) {
    toDoViewModel.buttonUpdate(taskid,taskname,taskdescription,taskdate,tastime)
    }
}