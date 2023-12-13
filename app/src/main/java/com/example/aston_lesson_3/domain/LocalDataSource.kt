package com.example.aston_lesson_3.domain

import com.example.aston_lesson_3.data.localdata.ContactData

interface LocalDataSource {
    fun getContactList():List<ContactData>

    fun insertToListContact(contactData: ContactData)
    fun updateContactLocal(contactData: ContactData)

    fun checkIndexLocal(contactData: ContactData)
}