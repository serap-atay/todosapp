package com.example.todosapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todosapp.R
import com.example.todosapp.data.entity.TaskModel
import com.example.todosapp.databinding.CardDesignBinding
import com.example.todosapp.ui.fragment.HomeFragmentDirections
import com.example.todosapp.ui.viewmodels.HomeViewModel

class TaskAdapter(var mContext :Context, var tasks :List<TaskModel>, var homeViewModel: HomeViewModel):RecyclerView.Adapter<TaskAdapter.CardHolder>() {

    inner class CardHolder(var design :CardDesignBinding):  RecyclerView.ViewHolder(design.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
       val binding :CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_design,parent,false)
        return CardHolder(binding)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val task = tasks[position]
        val d = holder.design
        d.taskModel = task

        d.cardView.setOnClickListener {
            val nav = HomeFragmentDirections.navigateToDetailTodo(todo = task)
            Navigation.findNavController(it).navigate(nav)
        }

        d.imageViewClear.setOnClickListener {
            homeViewModel.buttonDelete(task.taskId)
        }

    }
}