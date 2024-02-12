package com.clerodri.memitoapp.ui.todo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clerodri.memitoapp.domain.usecases.TodoUsesCases
import com.clerodri.memitoapp.ui.todo.TodoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TodoViewModel @Inject constructor(
        private val todoUsesCases: TodoUsesCases
) : ViewModel() {

        private var _uiState = MutableStateFlow(TodoState(emptyList()))
        val uiState = _uiState.asStateFlow()

        private var fectchJob: Job? = null


        private var _validationUIState = MutableStateFlow(RegistrationTodoState())
        val validationUIState = _validationUIState.asStateFlow()


        private val validationEventChannel = Channel<ValidationEvent>()
        val validationEvents = validationEventChannel.receiveAsFlow()

        init {getListTodo() }

        fun onEventValidation(event : RegistrationTodoEvent){
            when(event){
                is RegistrationTodoEvent.Add -> {
                    submitData()
                }
                is RegistrationTodoEvent.NameChanged -> {
                    _validationUIState.update {
                        it.copy(nameTodo = event.newTodoName)
                    }
                }
                is RegistrationTodoEvent.ValueChanged -> {

                }

                else -> {}
            }
        }

    private fun submitData() {
        Log.d("VALEEE", "NAME: " + validationUIState.value.nameTodo)
        Log.d("VALEEE", "ERROR NAME: " + validationUIState.value.nameTodoError)
        val nameResult = todoUsesCases.validateTodoName.execute(_validationUIState.value.nameTodo)
        //     val valueResult = todoUsesCases.validateValueTodo.execute(_validationUIState.value.valueTodo.toString())
        val hasError = listOf(nameResult).any { !it.successful }
        if (hasError) {
            _validationUIState.update { it.copy(nameTodoError = nameResult.errorMessage) }
            Log.d("VALEEE", "ERROR NAME: " + validationUIState.value.nameTodoError)
            return
        }
        viewModelScope.launch {
            _validationUIState.update { it.copy(nameTodoError = null) }
            validationEventChannel.send(ValidationEvent.Success)
        }
    }



    fun onEvent(event:TodoEvent){
                when(event) {
                        is TodoEvent.AddTodo -> {
                                viewModelScope.launch {
                                        todoUsesCases.addTodo(event.todo)
                                        getListTodo()
                                }
                        }
                        is TodoEvent.DeleteTodo -> {
                                viewModelScope.launch {
                                        todoUsesCases.deleteTodo(event.todo)
                                        getListTodo()
                                }
                        }

                    else -> {}
                }
        }

         private fun getListTodo(){
                 fectchJob?.cancel()
                 fectchJob = todoUsesCases.getTodos().onEach {
                                notes -> _uiState.value =uiState.value.copy(
                                        todos = notes
                                )
                 }.launchIn(viewModelScope)
        }

    sealed class ValidationEvent {
        object Success: ValidationEvent()
    }
}