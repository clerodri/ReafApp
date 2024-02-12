package com.clerodri.memitoapp.ui.todo

import com.clerodri.memitoapp.domain.modelo.TodoInfo

sealed class TodoEvent{
    data class DeleteTodo(val todo: TodoInfo): TodoEvent()
    data class AddTodo(val todo : TodoInfo): TodoEvent()


}
