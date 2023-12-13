package com.example.aston_lesson_3.di

import com.example.aston_lesson_3.data.repository.MainUsecaseImpl
import com.example.aston_lesson_3.domain.MainUsecase
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val MAIN_USECASE_NAME = "ContactListUsecase"
val usecaseModule = module {
    factory<MainUsecase>(qualifier = named(MAIN_USECASE_NAME)) {
        MainUsecaseImpl(
            get(
                named(
                    REPOSITORY_IMPL
                )
            )
        )
    }
}