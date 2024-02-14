package com.clerodri.memitoapp.domain.usecases

import com.clerodri.memitoapp.domain.modelo.TodoInfo
import kotlinx.coroutines.flow.Flow
import com.clerodri.memitoapp.domain.usecases.repository.TodoRepository

class GetTodos(private val repository: TodoRepository) {

    operator fun invoke(): Flow<List<TodoInfo>> {
        return repository.getTodos()
    }
}