package com.example.aston_lesson_3.di

import com.example.aston_lesson_3.ui.mainFragment.ContactListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val CONTACT_VIEW_MODEL = "ContactViewModel"
val viewModelModule = module {
    viewModel(qualifier = named(CONTACT_VIEW_MODEL)) {
        ContactListViewModel(
            mainUsecase = get(named(MAIN_USECASE_NAME))
        )
    }
}