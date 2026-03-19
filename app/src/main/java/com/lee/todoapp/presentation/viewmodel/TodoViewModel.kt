package com.lee.todoapp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lee.todoapp.domain.model.Todo
import com.lee.todoapp.domain.usecase.AddTodo
import com.lee.todoapp.domain.usecase.GetTodos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val getTodos: GetTodos,
    private val addTodo: AddTodo
) : ViewModel() {

    var todos by mutableStateOf<List<Todo>>(emptyList())
        private set

    fun loadTodos() {
        viewModelScope.launch {
            todos = getTodos()
        }
    }

    fun addSampleTodo() {
        viewModelScope.launch {
            addTodo(
                Todo(
                    id = System.currentTimeMillis().toString(),
                    title = "New Task",
                    description = null,
                    isDone = false,
                    createdAt = System.currentTimeMillis()
                )
            )
            loadTodos()
        }
    }
}