package com.lee.todoapp.data.mapper

import com.lee.todoapp.data.local.entity.TodoEntity
import com.lee.todoapp.data.remote.TodoDto
import com.lee.todoapp.domain.model.Todo

fun TodoDto.toDomain(): Todo {
    return Todo(
        id = id.toIntOrNull(), // DTO id is String, domain is Int?
        title = title,
        description = description,
        isDone = is_done,
        createdAt = created_at
    )
}

fun Todo.toDto(): TodoDto {
    return TodoDto(
        id = id?.toString() ?: "", 
        title = title,
        description = description,
        is_done = isDone,
        created_at = createdAt
    )
}

fun TodoEntity.toDomain(): Todo {
    return Todo(
        id = id,
        title = title,
        description = description,
        isDone = isDone,
        createdAt = createdAt
    )
}

fun Todo.toEntity(): TodoEntity {
    return TodoEntity(
        id = id,
        title = title,
        description = description,
        isDone = isDone,
        createdAt = createdAt
    )
}