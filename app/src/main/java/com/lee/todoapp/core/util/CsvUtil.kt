package com.lee.todoapp.core.util

import com.lee.todoapp.domain.model.Todo
import java.io.InputStream
import java.io.OutputStream

object CsvUtil {
    fun todosToCsv(todos: List<Todo>, outputStream: OutputStream) {
        val writer = outputStream.bufferedWriter()
        writer.write("id,title,description,isDone,createdAt\n")
        todos.forEach { todo ->
            writer.write("${todo.id},${todo.title},${todo.description ?: ""},${todo.isDone},${todo.createdAt}\n")
        }
        writer.flush()
    }

    fun csvToTodos(inputStream: InputStream): List<Todo> {
        val reader = inputStream.bufferedReader()
        val todos = mutableListOf<Todo>()
        reader.readLine() // skip header
        var line = reader.readLine()
        while (line != null) {
            val parts = line.split(",")
            if (parts.size == 5) {
                todos.add(
                    Todo(
                        id = parts[0].toIntOrNull(),
                        title = parts[1],
                        description = parts[2].ifEmpty { null },
                        isDone = parts[3].toBoolean(),
                        createdAt = parts[4].toLongOrNull() ?: System.currentTimeMillis()
                    )
                )
            }
            line = reader.readLine()
        }
        return todos
    }
}
