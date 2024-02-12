package com.clerodri.memitoapp.domain.usecases.repository

import com.clerodri.memitoapp.domain.modelo.TodoInfo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getTodos(): Flow<List<TodoInfo>>

    suspend fun  insertTodo(todo: TodoInfo)

    suspend fun deleteTodo(todo: TodoInfo)
}