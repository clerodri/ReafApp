package com.clerodri.memitoapp.domain.usecases

import com.clerodri.memitoapp.domain.modelo.TodoInfo
import com.clerodri.memitoapp.domain.usecases.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class GetTodos(private val repository: TodoRepository) {

     operator fun invoke(): Flow<List<TodoInfo>>{
        return repository.getTodos()
    }
}