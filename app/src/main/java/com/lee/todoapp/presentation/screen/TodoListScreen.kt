package com.lee.todoapp.presentation.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.lee.todoapp.presentation.viewmodel.TodoViewModel

@Composable
fun TodoListScreen(
    viewModel: TodoViewModel = hiltViewModel()
) {
    val todos = viewModel.todos

    LaunchedEffect(Unit) {
        viewModel.loadTodos()
    }

    LazyColumn {
        items(todos) { todo ->
            Text(todo.title)
        }
    }
}