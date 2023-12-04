package com.example.aston_lesson_3.domain

import com.example.aston_lesson_3.data.localdata.ContactData
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getContacts(): Flow<List<ContactData>>
}