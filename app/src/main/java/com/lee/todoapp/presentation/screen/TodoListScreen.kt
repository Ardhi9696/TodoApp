package com.lee.todoapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lee.todoapp.presentation.component.TodoItem
import com.lee.todoapp.presentation.viewmodel.TodoEvent
import com.lee.todoapp.presentation.viewmodel.TodoViewModel

@Composable
fun TodoListScreen(
    viewModel: TodoViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    var todoTitle by remember { mutableStateOf("") }
    var todoDescription by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "My Todo List")
                TextField(
                    value = todoTitle,
                    onValueChange = { todoTitle = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Title") }
                )
                TextField(
                    value = todoDescription,
                    onValueChange = { todoDescription = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Description (Optional)") }
                )
                Button(
                    onClick = {
                        if (todoTitle.isNotBlank()) {
                            viewModel.onEvent(TodoEvent.AddTodo(todoTitle, todoDescription.ifBlank { null }))
                            todoTitle = ""
                            todoDescription = ""
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Add")
                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(state.todos) { todo ->
                TodoItem(
                    title = todo.title,
                    description = todo.description,
                    isDone = todo.isDone,
                    onClick = { /* Detail? */ },
                    onToggle = { viewModel.onEvent(TodoEvent.ToggleTodo(todo)) }
                )
            }
        }
    }
}