package com.example.aston_lesson_3.data.repository

import com.example.aston_lesson_3.domain.MainUsecase
import com.example.aston_lesson_3.domain.Repository

class MainUsecaseImpl(private val repo: Repository) : MainUsecase {
    override suspend fun getAllContactsFromRepo() = repo.getContacts()
}