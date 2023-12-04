package com.example.aston_lesson_3.data.repository

import com.example.aston_lesson_3.domain.LocalDataSource
import com.example.aston_lesson_3.domain.Repository
import kotlinx.coroutines.flow.flow

class RepositoryImpl(private val localDataSource: LocalDataSource) : Repository {
    override suspend fun getContacts() = flow {
        emit(localDataSource.getContactList())
    }
}