package com.example.aston_lesson_3.domain

import com.example.aston_lesson_3.data.localdata.ContactData
import kotlinx.coroutines.flow.Flow

interface MainUsecase {
    suspend fun getAllContactsFromRepo(): Flow<List<ContactData>>
    suspend fun addContactToRepo(contactData: ContactData)
}