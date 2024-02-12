package com.clerodri.memitoapp.domain.usecases



data class TodoUsesCases(
    val addTodo: AddTodo,
    val deleteTodo: DeleteTodo,
    val getTodos : GetTodos,
    val validateValueTodo: ValidateValueTodo,
    val validateTodoName: ValidateTodoName
) {

}
