package com.example.aston_lesson_3.data.repository

import com.example.aston_lesson_3.data.localdata.ContactData
import com.example.aston_lesson_3.domain.LocalDataSource
import com.example.aston_lesson_3.domain.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class RepositoryImpl(private val localDataSource: LocalDataSource) : Repository {
    override suspend fun getContacts() = flow {
        emit(localDataSource.getContactList())
    }

    override suspend fun addContact(contactData: ContactData) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.insertToListContact(contactData)
        }
    }

    override suspend fun updateContact(contactData: ContactData) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.updateContactLocal(contactData)
        }
    }

    override suspend fun checkIndex(contactData: ContactData) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.checkIndexLocal(contactData)
        }
    }
}