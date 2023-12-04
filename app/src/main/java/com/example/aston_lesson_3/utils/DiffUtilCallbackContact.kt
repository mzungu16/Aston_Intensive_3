package com.example.aston_lesson_3.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.aston_lesson_3.data.localdata.ContactData

class DiffUtilCallbackContact(
    private val oldList: List<ContactData>,
    private val newList: List<ContactData>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}