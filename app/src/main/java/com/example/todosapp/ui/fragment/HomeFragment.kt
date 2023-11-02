package com.example.todosapp.ui.fragment

import android.icu.text.DateFormat
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.todosapp.R
import com.example.todosapp.data.entity.TaskModel
import com.example.todosapp.databinding.FragmentHomeBinding
import com.example.todosapp.ui.adapter.TaskAdapter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val currentDate =  SimpleDateFormat("dd MMMM yyyy").format(Date())

        binding.txtDate.text = currentDate.toString()
        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        val tasks = ArrayList<TaskModel>()
        val t1 =TaskModel("1","Yemek yap","Akşam yemeği hazırla","12/10/2023","15:43")
        val t2 =TaskModel("2","Spor yap","Egzersiz yap ","02/10/2023","12:43")
        val t3 =TaskModel("3","Alışveriş yap","Alışveriş listesi hazırla","16/10/2023","10:43")
        tasks.add(t1)
        tasks.add(t2)
        tasks.add(t3)

        val taskadapter = TaskAdapter(requireContext(),tasks)
        binding.rv.adapter = taskadapter

        binding.btnFab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigateToAddTodo)
        }
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(txtSearch: String): Boolean {
                 search(txtSearch)
                return true
            }

            override fun onQueryTextChange(txtSearch: String): Boolean {
                 search(txtSearch)
                return true
            }

        })

        return binding.root

    }

    fun search (taskName : String) {

    }

}