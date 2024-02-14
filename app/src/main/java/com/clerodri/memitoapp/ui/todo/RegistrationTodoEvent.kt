package com.clerodri.memitoapp.ui.todo

sealed  class RegistrationTodoEvent {
    data class NameChanged(val newTodoName:String): RegistrationTodoEvent()
    data class ValueChanged(val newValue:String): RegistrationTodoEvent()

    data object Add : RegistrationTodoEvent()

    data class onDialogShow(val isShow:Boolean) : RegistrationTodoEvent()


}