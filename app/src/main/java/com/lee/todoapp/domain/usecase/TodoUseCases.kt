package com.lee.todoapp.domain.usecase

data class TodoUseCases(
    val getTodos: GetTodos,
    val addTodo: AddTodo,
    val deleteTodo: DeleteTodo,
    val updateTodo: UpdateTodo
)
