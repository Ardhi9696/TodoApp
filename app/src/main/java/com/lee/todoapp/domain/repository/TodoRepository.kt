package com.lee.todoapp.domain.repository

import com.lee.todoapp.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getTodos(): Flow<List<Todo>>
    suspend fun insertTodo(todo: Todo)
    suspend fun updateTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo)
    suspend fun getTodoById(id: Int): Todo?
}
