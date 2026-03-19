package com.lee.todoapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lee.todoapp.domain.model.Todo

@Entity(tableName = "todo_table")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val description: String?,
    val isDone: Boolean,
    val createdAt: Long
) {
    fun toTodo(): Todo {
        return Todo(
            id = id,
            title = title,
            description = description,
            isDone = isDone,
            createdAt = createdAt
        )
    }

    companion object {
        fun fromTodo(todo: Todo): TodoEntity {
            return TodoEntity(
                id = todo.id,
                title = todo.title,
                description = todo.description,
                isDone = todo.isDone,
                createdAt = todo.createdAt
            )
        }
    }
}