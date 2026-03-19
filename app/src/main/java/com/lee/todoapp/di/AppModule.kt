package com.lee.todoapp.di

import android.app.Application
import androidx.room.Room
import com.lee.todoapp.data.local.TodoDatabase
import com.lee.todoapp.data.local.dao.TodoDao
import com.lee.todoapp.data.repository.TodoRepositoryImpl
import com.lee.todoapp.domain.repository.TodoRepository
import com.lee.todoapp.domain.usecase.AddTodo
import com.lee.todoapp.domain.usecase.DeleteTodo
import com.lee.todoapp.domain.usecase.GetTodos
import com.lee.todoapp.domain.usecase.TodoUseCases
import com.lee.todoapp.domain.usecase.UpdateTodo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            TodoDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(db: TodoDatabase): TodoDao = db.todoDao

    @Provides
    @Singleton
    fun provideRepository(dao: TodoDao): TodoRepository {
        return TodoRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideTodoUseCases(repository: TodoRepository): TodoUseCases {
        return TodoUseCases(
            getTodos = GetTodos(repository),
            addTodo = AddTodo(repository),
            deleteTodo = DeleteTodo(repository),
            updateTodo = UpdateTodo(repository)
        )
    }
}