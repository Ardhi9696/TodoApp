package com.lee.todoapp.domain.usecase

import com.lee.todoapp.domain.model.Todo
import com.lee.todoapp.domain.repository.TodoRepository

class AddTodo(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo) = repository.insertTodo(todo)
}