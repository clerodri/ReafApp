package com.clerodri.memitoapp.data.todo

import com.clerodri.memitoapp.data.data_source.TodoDao
import com.clerodri.memitoapp.domain.modelo.TodoInfo
import com.clerodri.memitoapp.domain.usecases.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(private val dao: TodoDao) : TodoRepository {
    override fun getTodos(): Flow<List<TodoInfo>> {
        return dao.getAll()
    }

    override suspend fun insertTodo(todo: TodoInfo) {
        dao.insert(todo)
    }

    override suspend fun deleteTodo(todo: TodoInfo) {
        dao.delete(todo)
    }
}