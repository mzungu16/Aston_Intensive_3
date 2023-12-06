package com.example.aston_lesson_3.ui.addContactFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aston_lesson_3.data.localdata.ContactData
import com.example.aston_lesson_3.databinding.AddContactBinding
import com.example.aston_lesson_3.di.CONTACT_VIEW_MODEL
import com.example.aston_lesson_3.ui.mainFragment.ContactListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class AddContact : Fragment() {
    private var _binding: AddContactBinding? = null
    private val binding get() = _binding!!
    private val contactViewModel: ContactListViewModel by viewModel(named(CONTACT_VIEW_MODEL))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AddContactBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            saveBtn.setOnClickListener {
                addContactToViewModel()
            }
        }
    }

    private fun addContactToViewModel() {
        binding.run {
            contactViewModel.addContactToRepo(
                ContactData(
                    fullNameTxt.text.toString(),
                    phoneNumberTxt.text.toString()
                )
            )
            contactViewModel.getContactsListFromUsecase()
            findNavController().navigateUp()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}