package com.example.aston_lesson_3.utils

import android.app.Application
import com.example.aston_lesson_3.di.repositoryModule
import com.example.aston_lesson_3.di.usecaseModule
import com.example.aston_lesson_3.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(repositoryModule, usecaseModule, viewModelModule)
        }
    }
}