package com.clerodri.memitoapp.ui.todo

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.clerodri.memitoapp.databinding.DialogTodo2Binding
import com.clerodri.memitoapp.databinding.FragmentTodoBinding
import com.clerodri.memitoapp.domain.modelo.TodoInfo
import com.clerodri.memitoapp.util.FormateValue
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TodoFragment : Fragment() {

    private val todoViewModel by viewModels<TodoViewModel>()
    private  var _binding: FragmentTodoBinding? = null
    private var _dialogBinding: DialogTodo2Binding? = null
    private val binding get() = _binding!!
    private val dialogBinding get() = _dialogBinding!!


    private var todoListAdapter : List<TodoInfo> = emptyList()
    private lateinit var  todoAdapter : TodoAdapter
    private lateinit var llManager : LinearLayoutManager
    private lateinit var dialog : Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(layoutInflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initRV()
        initDialog()

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                todoViewModel.uiState.collect(){
                    todoListAdapter = it.todos
                    todoAdapter.updateList(todoListAdapter)
                }


            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                todoViewModel.validationEvents.collect{
                    when(it) {
                        is TodoViewModel.ValidationEvent.Success -> {
                            val newValue = FormateValue.validateAndFormatNumber(dialogBinding.etValue.text.toString())
                             val todo = TodoInfo(dialogBinding.etTodoName.text.toString().uppercase(),newValue)
                             todoViewModel.onEvent(TodoEvent.AddTodo(todo))
                            dialog.hide()
                            dialogBinding.etValue.text?.clear()
                            dialogBinding.etTodoName.text?.clear()
                            dialogBinding.textInputLayout.error = null
                            dialogBinding.textInputLayout2.error = null
                            Toast.makeText(requireContext(),"TO-DO ADDED",Toast.LENGTH_SHORT).show()
                        }

                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                todoViewModel.validationUIState.collect() {

                    if (it.nameTodoError != null) {
                        dialogBinding.textInputLayout.error = it.nameTodoError

                    }
                    if (it.valueTodoError != null) {
                         dialogBinding.textInputLayout2.error = it.valueTodoError

                    }
                }
            }
        }

        binding.fab.setOnClickListener {
            dialog.show()
        }
        dialogBinding.btnAdd.setOnClickListener {
            todoViewModel.onEventValidation(RegistrationTodoEvent.Add)
            llManager.scrollToPositionWithOffset(todoAdapter.itemCount -1,10)
        }
        writingTodoName()
        writingValue()
    }

    private fun writingTodoName() {
        dialogBinding.etTodoName.doAfterTextChanged {
            todoViewModel.onEventValidation(RegistrationTodoEvent.NameChanged(it.toString()))
        }

    }
    private fun writingValue(){
        dialogBinding.etValue.doAfterTextChanged {  todoViewModel.onEventValidation(RegistrationTodoEvent.ValueChanged(it.toString())) }
    }

    private fun initAdapter(){
        todoAdapter = TodoAdapter(
            list = todoListAdapter,
            onDeleteClicked = {position -> onItemDeleted(position)}
        )
        llManager  = LinearLayoutManager(requireContext())
    }
    private fun initRV() {
        binding.rvTodo.apply {
            layoutManager = llManager
            adapter = todoAdapter
        }
    }

    private fun onItemDeleted(position: Int) {
            val todoDelete = todoListAdapter[position]
           todoViewModel.onEvent(TodoEvent.DeleteTodo(todoDelete))
    }


    private fun initDialog(){
        dialog = Dialog(requireContext())
        _dialogBinding = DialogTodo2Binding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}