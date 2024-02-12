package com.clerodri.memitoapp.ui.todo

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.clerodri.memitoapp.R
import com.clerodri.memitoapp.databinding.FragmentTodoBinding

import com.clerodri.memitoapp.domain.modelo.TodoInfo
import com.clerodri.memitoapp.ui.todo.RegistrationTodoEvent
import com.clerodri.memitoapp.ui.todo.RegistrationTodoState
import com.clerodri.memitoapp.ui.todo.TodoEvent
import com.clerodri.memitoapp.ui.todo.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TodoFragment : Fragment() {

    private val todoViewModel by viewModels<TodoViewModel>()
    private  var _binding: com.clerodri.memitoapp.databinding.FragmentTodoBinding? = null

    private val binding get() = _binding!!

    private var todoListAdapter : List<TodoInfo> = emptyList()
    private lateinit var  todoAdapter : TodoAdapter
    private lateinit var llManager : LinearLayoutManager

    lateinit var btnAddTodo:Button
    private lateinit var dialog : Dialog
    private lateinit var etName : EditText
    private lateinit var etValue : EditText
    private lateinit var tvErrorName: TextView
    private lateinit var tvErrorValue: TextView
    //
    private lateinit var test : StateFlow<RegistrationTodoState>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(layoutInflater, container , false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initRV()
        initDialog()
        test = todoViewModel.validationUIState
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
                             val todo = TodoInfo(etName.text.toString(),etValue.text.toString())
                             todoViewModel.onEvent(TodoEvent.AddTodo(todo))
                             dialog.hide()
                             etName.text.clear()
                             etValue.text.clear()
                            Toast.makeText(requireContext(),"TO-DO ADDED",Toast.LENGTH_SHORT).show()
                        }

                        else -> {}
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                todoViewModel.validationUIState.collect() {
                    Log.d("VALEEE","ERROR NAME FRAGMENT: "+it.nameTodoError)
                  //  tvErrorName.visibility = View.GONE
                    if (it.nameTodoError != null) {
                        tvErrorName.text = it.nameTodoError
                        tvErrorName.visibility = View.VISIBLE
                    }
                }
            }
        }

        binding.fab.setOnClickListener {
            tvErrorName.visibility = View.GONE
            dialog.show()

        }
        btnAddTodo.setOnClickListener {
            todoViewModel.onEventValidation(RegistrationTodoEvent.Add)
            llManager.scrollToPositionWithOffset(todoAdapter.itemCount -1,10)
        }
        writingTodoName()
    }

    private fun writingTodoName() {
        etName.doOnTextChanged { text, start, before, count ->  tvErrorName.visibility = View.GONE }
        etName.doAfterTextChanged {  todoViewModel.onEventValidation(RegistrationTodoEvent.NameChanged(it.toString())) }
    }

    private fun initAdapter(){
        todoAdapter = TodoAdapter(
            list = todoListAdapter,
            onDeleteClicked = {position -> onItemDeleted(position)}
        )
        llManager  = LinearLayoutManager(requireContext())
    }
    private fun initRV() {
        Log.d("ViewModel", "INITRV")
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
        dialog.setContentView(R.layout.dialog_todo)
        tvErrorName = dialog.findViewById(R.id.etTodoNameError)
        tvErrorValue = dialog.findViewById(R.id.etValueError)
        btnAddTodo = dialog.findViewById(R.id.btnAdd)
        etValue = dialog.findViewById(R.id.etValue)
        etName  = dialog.findViewById(R.id.etTodoName)
    }
}