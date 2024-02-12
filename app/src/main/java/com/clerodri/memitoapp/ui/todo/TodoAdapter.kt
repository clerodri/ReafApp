package com.clerodri.memitoapp.ui.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clerodri.memitoapp.R
import com.clerodri.memitoapp.domain.modelo.TodoInfo

class TodoAdapter(private var list: List<TodoInfo>,private val onDeleteClicked: (Int) -> Unit) : RecyclerView.Adapter<TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.render(list[position],onDeleteClicked)
    }

    fun updateList(newList:List<TodoInfo>){
        list = newList
        notifyDataSetChanged()
    }

}