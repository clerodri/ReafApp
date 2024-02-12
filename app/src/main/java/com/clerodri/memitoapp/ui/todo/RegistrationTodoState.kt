package com.clerodri.memitoapp.ui.todo

data class RegistrationTodoState(
        val nameTodo: String = "",
        val nameTodoError: String ? = null,
        val valueTodo:String = "",
        val valueTodoError: String? = null,
)
