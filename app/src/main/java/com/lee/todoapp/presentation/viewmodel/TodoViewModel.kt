package com.lee.todoapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lee.todoapp.domain.model.Todo
import com.lee.todoapp.domain.usecase.TodoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases
) : ViewModel() {

    private val _state = mutableStateOf(TodoState())
    val state: State<TodoState> = _state

    private var getTodosJob: Job? = null

    init {
        getTodos()
    }

    fun onEvent(event: TodoEvent) {
        when (event) {
            is TodoEvent.AddTodo -> {
                viewModelScope.launch {
                    todoUseCases.addTodo(Todo(title = event.title, description = event.description))
                }
            }
            is TodoEvent.DeleteTodo -> {
                viewModelScope.launch {
                    todoUseCases.deleteTodo(event.todo)
                }
            }
            is TodoEvent.ToggleTodo -> {
                viewModelScope.launch {
                    todoUseCases.updateTodo(event.todo.copy(isDone = !event.todo.isDone))
                }
            }
        }
    }

    private fun getTodos() {
        getTodosJob?.cancel()
        getTodosJob = todoUseCases.getTodos()
            .onEach { todos ->
                _state.value = state.value.copy(
                    todos = todos
                )
            }
            .launchIn(viewModelScope)
    }
}

data class TodoState(
    val todos: List<Todo> = emptyList(),
    val isLoading: Boolean = false
)

sealed class TodoEvent {
    data class AddTodo(val title: String, val description: String? = null) : TodoEvent()
    data class DeleteTodo(val todo: Todo) : TodoEvent()
    data class ToggleTodo(val todo: Todo) : TodoEvent()
}