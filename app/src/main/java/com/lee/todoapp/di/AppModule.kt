package com.lee.todoapp.di

import com.lee.todoapp.data.remote.SupabaseService
import com.lee.todoapp.data.repository.TodoRepositoryImpl
import com.lee.todoapp.domain.repository.TodoRepository
import com.lee.todoapp.domain.usecase.AddTodo
import com.lee.todoapp.domain.usecase.DeleteTodo
import com.lee.todoapp.domain.usecase.GetTodos
import com.lee.todoapp.domain.usecase.UpdateTodo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideSupabaseService(): SupabaseService {
        return SupabaseService()
    }

    @Provides
    fun provideRepository(
        service: SupabaseService
    ): TodoRepository {
        return TodoRepositoryImpl(service)
    }

    @Provides
    fun provideGetTodos(repo: TodoRepository) = GetTodos(repo)

    @Provides
    fun provideAddTodo(repo: TodoRepository) = AddTodo(repo)

    @Provides
    fun provideUpdateTodo(repo: TodoRepository) = UpdateTodo(repo)

    @Provides
    fun provideDeleteTodo(repo: TodoRepository) = DeleteTodo(repo)
}