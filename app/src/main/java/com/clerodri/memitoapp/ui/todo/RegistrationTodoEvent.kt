package com.clerodri.memitoapp.ui.todo

sealed  class RegistrationTodoEvent {
    data class NameChanged(val newTodoName:String): RegistrationTodoEvent()
    data class ValueChanged(val value:String): RegistrationTodoEvent()

    data object Add : RegistrationTodoEvent()


}