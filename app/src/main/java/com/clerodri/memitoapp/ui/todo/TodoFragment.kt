package com.clerodri.memitoapp.ui.todo

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.clerodri.memitoapp.databinding.DialogTodo2Binding
import com.clerodri.memitoapp.databinding.FragmentTodoBinding
import com.clerodri.memitoapp.domain.modelo.TodoInfo
import com.clerodri.memitoapp.ui.todo.rv.TodoAdapter
import com.clerodri.memitoapp.util.FormateValue
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TodoFragment : Fragment() {

    private val todoViewModel by viewModels<TodoViewModel>()
    private var _binding: FragmentTodoBinding? = null
    private var _dialogBinding: DialogTodo2Binding? = null
    private val binding get() = _binding!!
    private val dialogBinding get() = _dialogBinding!!


    private var todoListAdapter: List<TodoInfo> = emptyList()
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var llManager: LinearLayoutManager
    private var dialog: Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(layoutInflater, container, false)
        _dialogBinding = DialogTodo2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initRV()
        initDialog()

        collectLatestLifecycleFlow(todoViewModel.isDialogShow){isDialogShow ->
            if (isDialogShow){
                dialog?.show()
            }else{
                dialog?.dismiss()
            }

        }
        collectLatestLifecycleFlow(todoViewModel.uiState){
                todoListAdapter = it.todos
                todoAdapter.updateList(todoListAdapter)
        }

        collectLatestLifecycleFlow(todoViewModel.validationEvents){
            when (it) {
                is TodoViewModel.ValidationEvent.Success -> {
                    dialogBinding.etValue.text?.clear()
                    dialogBinding.etTodoName.text?.clear()
                    dialogBinding.textInputLayout.error = null
                    dialogBinding.textInputLayout2.error = null
                    Toast.makeText(requireContext(), "TO-DO ADDED", Toast.LENGTH_SHORT).show()
                }

            }
        }
        collectLatestLifecycleFlow(todoViewModel.validationUIState){

            it.nameTodoError?.let {nameFail ->
                dialogBinding.textInputLayout.error = nameFail
            }
            it.valueTodoError?.let {valueFail ->
                dialogBinding.textInputLayout2.error = valueFail
            }

        }


        binding.fab.setOnClickListener {
            todoViewModel.onEventValidation(RegistrationTodoEvent.onDialogShow(true))
        }

        dialogBinding.btnAdd.setOnClickListener {
            todoViewModel.onEventValidation(RegistrationTodoEvent.Add)
            llManager.scrollToPositionWithOffset(todoAdapter.itemCount - 1, 10)
        }

        dialog!!.setOnDismissListener{
            todoViewModel.onEventValidation(RegistrationTodoEvent.onDialogShow(false))
        }
        writingTodoName()
        writingValue()
    }

    private fun formatTodo(title:String,  value:String):TodoInfo{
        val newValue = FormateValue.validateAndFormatNumber(value)
        return TodoInfo(title.uppercase(), newValue)
    }

    private fun writingTodoName() {
        dialogBinding.etTodoName.doAfterTextChanged {
            todoViewModel.onEventValidation(RegistrationTodoEvent.NameChanged(it.toString()))
        }

    }

    private fun writingValue() {
        dialogBinding.etValue.doAfterTextChanged {
            todoViewModel.onEventValidation(
                RegistrationTodoEvent.ValueChanged(it.toString())
            )
        }
    }

    private fun initAdapter() {
        todoAdapter = TodoAdapter(
            list = todoListAdapter,
            onDeleteClicked = { position -> onItemDeleted(position) }
        )
        llManager = LinearLayoutManager(requireContext())
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


    private fun initDialog() {
        requireContext().let {
            dialog = Dialog(it)
            dialog!!.setContentView(dialogBinding.root)
            dialog!!.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog!!.setTitle("DIALGO")
            dialog!!.setCancelable(true)
            dialog!!.setCanceledOnTouchOutside(true)

        }
    }


    private fun <T>  Fragment.collectLatestLifecycleFlow(flow: Flow<T>, collect: suspend (T) -> Unit){
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                flow.collectLatest(collect)
            }
        }
    }

    override fun onStart() {
        if(todoViewModel.isDialogShow.value){
            todoViewModel.onEventValidation(RegistrationTodoEvent.onDialogShow(true))
        }
        super.onStart()
    }
}