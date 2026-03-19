package com.lee.todoapp.data.mapper

import com.lee.todoapp.data.remote.TodoDto
import com.lee.todoapp.domain.model.Todo

fun TodoDto.toDomain(): Todo {
    return Todo(
        id = id,
        title = title,
        description = description,
        isDone = is_done,
        createdAt = created_at
    )
}

fun Todo.toDto(): TodoDto {
    return TodoDto(
        id = id,
        title = title,
        description = description,
        is_done = isDone,
        created_at = createdAt
    )
}