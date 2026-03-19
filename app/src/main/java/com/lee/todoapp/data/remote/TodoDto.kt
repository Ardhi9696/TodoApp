package com.lee.todoapp.data.remote

data class TodoDto(
    val id: String,
    val title: String,
    val description: String?,
    val is_done: Boolean,
    val created_at: Long
)