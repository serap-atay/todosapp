package com.example.todosapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todosapp.databinding.FragmentAddTodoBinding

class AddTodoFragment : Fragment() {
    private lateinit var binding: FragmentAddTodoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View? {
        binding = FragmentAddTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

}