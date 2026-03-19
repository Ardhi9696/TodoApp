package com.lee.todoapp.domain.model

data class Todo {
    val id: String,
    val title: String,
    val description: String?,
    val isDone: Boolean
    val createdAt: Long
}


