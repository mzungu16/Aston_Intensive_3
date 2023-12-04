package com.example.aston_lesson_3.data.localdata

import com.example.aston_lesson_3.domain.LocalDataSource

class LocalDataSourceImpl : LocalDataSource {
    private val contactData = mutableListOf<ContactData>()

    override fun getContactList(): List<ContactData> {
        for (i in 0..100) {
            contactData.add(ContactData("Name Surname $i", "+739484$i"))
        }
        return contactData
    }

}