package com.clerodri.memitoapp.domain.usecases

import com.clerodri.memitoapp.domain.modelo.TodoInfo
import com.clerodri.memitoapp.domain.usecases.repository.TodoRepository

class DeleteTodo(private val repository: TodoRepository) {

        suspend operator  fun invoke(todo: TodoInfo){
            repository.deleteTodo(todo)
        }

}