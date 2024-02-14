package com.clerodri.memitoapp.ui.todo.rv

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.clerodri.memitoapp.databinding.ItemTodoBinding
import com.clerodri.memitoapp.domain.modelo.TodoInfo

class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemTodoBinding.bind(view)

    fun render(
        todoInfo: TodoInfo,
        onDeleteClicked: (Int) -> Unit
    ) {
        binding.tvTodoName.text = todoInfo.title

        binding.tvValor.text = todoInfo.valor
        binding.ivDelete.setOnClickListener {
            onDeleteClicked(adapterPosition)
        }
    }
}




