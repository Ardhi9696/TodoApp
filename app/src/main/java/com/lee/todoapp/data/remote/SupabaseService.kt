package com.lee.todoapp.data.remote

class SupabaseService {

    suspend fun getTodos(): List<TodoDto> {
        return listOf(
            TodoDto("1", "Belajar Kotlin", null, false, System.currentTimeMillis())
        )
    }

    suspend fun addTodo(todo: TodoDto) {}
    suspend fun updateTodo(todo: TodoDto) {}
    suspend fun deleteTodo(id: String) {}
}