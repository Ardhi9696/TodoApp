package com.lee.todoapp.data.repository

import com.lee.todoapp.data.mapper.toDomain
import com.lee.todoapp.data.mapper.toDto
import com.lee.todoapp.data.remote.SupabaseService
import com.lee.todoapp.domain.model.Todo
import com.lee.todoapp.domain.repository.TodoRepository

class TodoRepositoryImpl(
    private val service: SupabaseService
) : TodoRepository {

    override suspend fun getTodos(): List<Todo> {
        return service.getTodos().map { it.toDomain() }
    }

    override suspend fun addTodo(todo: Todo) {
        service.addTodo(todo.toDto())
    }

    override suspend fun updateTodo(todo: Todo) {
        service.updateTodo(todo.toDto())
    }

    override suspend fun deleteTodo(id: String) {
        service.deleteTodo(id)
    }
}