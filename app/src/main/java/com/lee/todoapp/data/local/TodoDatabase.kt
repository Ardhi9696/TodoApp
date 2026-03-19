package com.lee.todoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lee.todoapp.data.local.dao.TodoDao
import com.lee.todoapp.data.local.entity.TodoEntity

@Database(entities = [TodoEntity::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract val todoDao: TodoDao

    companion object {
        const val DATABASE_NAME = "todo_db"
    }
}
