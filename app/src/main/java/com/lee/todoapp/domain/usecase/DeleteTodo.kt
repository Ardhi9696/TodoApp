package com.lee.todoapp.domain.usecase

import com.lee.todoapp.domain.repository.TodoRepository

class DeleteTodo(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(id: String) {
        repository.deleteTodo(id)
    }
}