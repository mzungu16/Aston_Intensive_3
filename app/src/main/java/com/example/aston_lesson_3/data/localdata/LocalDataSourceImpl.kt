package com.example.aston_lesson_3.data.localdata

import android.util.Log
import com.example.aston_lesson_3.domain.LocalDataSource

class LocalDataSourceImpl : LocalDataSource {
    private val dataMutableList = mutableListOf<ContactData>()

    override fun getContactList(): List<ContactData> {
        for (i in 0..100) {
            dataMutableList.add(ContactData("Name Surname $i", "+739484$i"))
        }
        return dataMutableList
    }

    override fun insertToListContact(contactData: ContactData) {
        dataMutableList.add(0,contactData)
        Log.d("LIST","${dataMutableList.first()}")
    }

}