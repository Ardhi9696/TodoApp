package com.lee.todoapp.domain.usecase

import com.lee.todoapp.domain.model.Todo
import com.lee.todoapp.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class GetTodos(
    private val repository: TodoRepository
) {
    operator fun invoke(): Flow<List<Todo>> = repository.getTodos()
}