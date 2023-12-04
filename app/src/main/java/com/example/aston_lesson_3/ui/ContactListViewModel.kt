package com.example.aston_lesson_3.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aston_lesson_3.data.localdata.ContactData
import com.example.aston_lesson_3.domain.MainUsecase
import kotlinx.coroutines.launch

class ContactListViewModel(private val mainUsecase: MainUsecase) : ViewModel() {
    private val _contactList = MutableLiveData<List<ContactData>>()
    val contactList: LiveData<List<ContactData>>
        get() = _contactList

    fun getContactsListFromUsecase() {
        viewModelScope.launch {
            mainUsecase.getAllContactsFromRepo().collect {
                _contactList.postValue(it)
            }
        }
    }
}