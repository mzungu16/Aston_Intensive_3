package com.example.aston_lesson_3.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aston_lesson_3.data.localdata.ContactData
import com.example.aston_lesson_3.databinding.ContactItemBinding
import com.example.aston_lesson_3.utils.DiffUtilCallbackContact

class ContactRecyclerViewAdapter :
    RecyclerView.Adapter<ContactRecyclerViewAdapter.ContactRecyclerViewHolder>() {
    private val contactListAdapter = mutableListOf<ContactData>()

    fun setList(paramContactList: List<ContactData>) {
        val diffUtilCallback = DiffUtilCallbackContact(this.contactListAdapter, paramContactList)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        this.contactListAdapter.clear()
        this.contactListAdapter.addAll(paramContactList)
        diffResult.dispatchUpdatesTo(this)

    }

    inner class ContactRecyclerViewHolder(binding: ContactItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val fullName = binding.fullName
        val phoneNumber = binding.phoneNumber
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactRecyclerViewHolder {
        val itemBinding =
            ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactRecyclerViewHolder(itemBinding)
    }

    override fun getItemCount() = contactListAdapter.size

    override fun onBindViewHolder(holder: ContactRecyclerViewHolder, position: Int) {
        with(holder) {
            fullName.text = contactListAdapter[position].fullName
            phoneNumber.text = contactListAdapter[position].phoneNumber
        }
    }

}
