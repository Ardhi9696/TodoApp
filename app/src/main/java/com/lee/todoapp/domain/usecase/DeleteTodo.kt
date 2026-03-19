package com.lee.todoapp.domain.usecase

import com.lee.todoapp.domain.model.Todo
import com.lee.todoapp.domain.repository.TodoRepository

class DeleteTodo(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo) = repository.deleteTodo(todo)
}