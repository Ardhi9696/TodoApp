package com.lee.todoapp.domain.usecase

import com.lee.todoapp.domain.model.Todo
import com.lee.todoapp.domain.repository.TodoRepository

class GetTodos(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(): List<Todo> {
        return repository.getTodos()
    }
}