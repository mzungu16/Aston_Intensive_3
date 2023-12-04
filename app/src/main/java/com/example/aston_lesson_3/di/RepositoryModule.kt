package com.example.aston_lesson_3.di

import com.example.aston_lesson_3.data.localdata.LocalDataSourceImpl
import com.example.aston_lesson_3.data.repository.RepositoryImpl
import com.example.aston_lesson_3.domain.LocalDataSource
import com.example.aston_lesson_3.domain.Repository
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val LOCAL_DATA = "LocalData"
const val REPOSITORY_IMPL = "RepositoryImpl"
val repositoryModule = module {
    single<Repository>(qualifier = named(REPOSITORY_IMPL)) {
        RepositoryImpl(get(named(LOCAL_DATA)))
    }
    single<LocalDataSource>(qualifier = named(LOCAL_DATA)) { LocalDataSourceImpl() }
}