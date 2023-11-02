package com.example.todosapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todosapp.databinding.FragmentTodoDetailBinding

class TodoDetailFragment : Fragment() {
    private lateinit var binding: FragmentTodoDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentTodoDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
}