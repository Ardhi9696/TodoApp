package com.lee.todoapp.data.repository

import com.lee.todoapp.data.local.dao.TodoDao
import com.lee.todoapp.data.mapper.toDomain
import com.lee.todoapp.data.mapper.toEntity
import com.lee.todoapp.domain.model.Todo
import com.lee.todoapp.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoRepositoryImpl(
    private val dao: TodoDao
) : TodoRepository {
    override fun getTodos(): Flow<List<Todo>> {
        return dao.getTodos().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo.toEntity())
    }

    override suspend fun updateTodo(todo: Todo) {
        dao.updateTodo(todo.toEntity())
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo.toEntity())
    }

    override suspend fun getTodoById(id: Int): Todo? {
        return dao.getTodoById(id)?.toDomain()
    }
}