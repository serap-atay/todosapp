package com.example.todosapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todosapp.R
import com.example.todosapp.data.entity.TaskModel
import com.example.todosapp.databinding.FragmentAddTodoBinding
import com.example.todosapp.ui.viewmodels.AddToDoViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Locale

class AddTodoFragment : Fragment() {
    private lateinit var binding: FragmentAddTodoBinding
    private  lateinit var addToDoViewModel: AddToDoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_todo, container, false)
        binding.addTodoFragment = this
        val backPress = object :OnBackPressedCallback(false){
            override fun handleOnBackPressed() {
               // Navigation.findNavController(this).
            }
        }

        binding.btnDate.setOnClickListener {
            val dp = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Calender")
                .build()

            dp.addOnPositiveButtonClickListener {
                val df = SimpleDateFormat("dd/MM/yyyy",Locale.getDefault())
                binding.txtTaskDate.setText(df.format(it).toString())
            }

            dp.show(requireActivity().supportFragmentManager,"Date")
        }

        binding.btnTime1.setOnClickListener {
            val tp = MaterialTimePicker.Builder()
                .setTitleText("Time")
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build()

            tp.addOnPositiveButtonClickListener {
                binding.txtTaskTime.setText("${tp.hour} : ${tp.minute}")
            }

            tp.show(requireActivity().supportFragmentManager,"Date")
        }


   return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AddToDoViewModel by viewModels()
        addToDoViewModel = tempViewModel
    }
    fun buttonSave (taskname:String,taskdescription :String,taskdate:String,taskime:String){
        addToDoViewModel.buttonSave(taskname,taskdescription,taskdate,taskime)
    }

}
