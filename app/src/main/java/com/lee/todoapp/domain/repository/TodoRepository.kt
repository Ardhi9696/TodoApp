package com.lee.todoapp.domain.repository

import com.lee.todoapp.domain.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun addTodo(todo: Todo)
    suspend fun updateTodo(todo: Todo)
    suspend fun deleteTodo(id: String)
}
