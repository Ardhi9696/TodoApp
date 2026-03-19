package com.lee.todoapp.domain.model

data class Todo(
    val id: Int? = null,
    val title: String,
    val description: String? = null,
    val isDone: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
