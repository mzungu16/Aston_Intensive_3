package com.example.aston_lesson_3.data.localdata

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContactData(
    val fullName: String,
    val phoneNumber: String,
) : Parcelable