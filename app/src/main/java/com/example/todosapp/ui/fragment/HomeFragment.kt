package com.example.todosapp.ui.fragment

import android.icu.text.DateFormat
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.todosapp.R
import com.example.todosapp.data.entity.TaskModel
import com.example.todosapp.databinding.FragmentHomeBinding
import com.example.todosapp.ui.adapter.TaskAdapter
import com.example.todosapp.ui.viewmodels.HomeViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        binding.homeFragment = this

        val currentDate =  SimpleDateFormat("dd MMMM yyyy").format(Date())

        binding.currentDate= currentDate.toString()

        homeViewModel.tasklist.observe(viewLifecycleOwner){
            val taskadapter = TaskAdapter(requireContext(),it,homeViewModel)
            binding.taskAdapter = taskadapter
        }


        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(txtSearch: String): Boolean {
                 homeViewModel.search(txtSearch)
                return true
            }

            override fun onQueryTextChange(txtSearch: String): Boolean {
                return if (txtSearch.isNotEmpty()){
                    homeViewModel.search(txtSearch)
                    true
                }else{
                    homeViewModel.getTasks()
                    true
                }
            }
        })
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomeViewModel by viewModels()
        homeViewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.getTasks()
    }
    fun buttonFab (it:View) {
        Navigation.findNavController(it).navigate(R.id.navigateToAddTodo)
    }
}