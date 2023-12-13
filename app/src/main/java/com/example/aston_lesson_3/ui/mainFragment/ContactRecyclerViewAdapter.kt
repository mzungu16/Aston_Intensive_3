package com.example.aston_lesson_3.ui.mainFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aston_lesson_3.data.localdata.ContactData
import com.example.aston_lesson_3.databinding.ContactItemBinding
import com.example.aston_lesson_3.utils.DiffUtilCallbackContact

class ContactRecyclerViewAdapter(private val onAdapterContactListener: OnContactListener) :
    RecyclerView.Adapter<ContactRecyclerViewAdapter.ContactRecyclerViewHolder>() {
    val contactListAdapter = mutableListOf<ContactData>()

    fun setList(paramContactList: List<ContactData>) {
        val diffUtilCallback = DiffUtilCallbackContact(this.contactListAdapter, paramContactList)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        this.contactListAdapter.clear()
        this.contactListAdapter.addAll(paramContactList)
        diffResult.dispatchUpdatesTo(this)

    }

    inner class ContactRecyclerViewHolder(
        binding: ContactItemBinding,
        private var onContactListener: OnContactListener
    ) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        val fullName = binding.fullName
        val phoneNumber = binding.phoneNumber
        override fun onClick(p0: View?) {
            onContactListener.onContactClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactRecyclerViewHolder {
        val itemBinding =
            ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactRecyclerViewHolder(itemBinding, onAdapterContactListener)
    }

    override fun getItemCount() = contactListAdapter.size

    override fun onBindViewHolder(holder: ContactRecyclerViewHolder, position: Int) {
        with(holder) {
            fullName.text = contactListAdapter[position].fullName
            phoneNumber.text = contactListAdapter[position].phoneNumber
        }
    }

    interface OnContactListener {
        fun onContactClick(position: Int)
    }
}
