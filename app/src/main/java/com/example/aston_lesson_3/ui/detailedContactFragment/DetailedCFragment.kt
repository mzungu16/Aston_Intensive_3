package com.example.aston_lesson_3.ui.detailedContactFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aston_lesson_3.data.localdata.ContactData
import com.example.aston_lesson_3.databinding.FragmentDetailedCBinding
import com.example.aston_lesson_3.di.CONTACT_VIEW_MODEL
import com.example.aston_lesson_3.ui.mainFragment.ContactListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named


class DetailedCFragment : Fragment() {
    private var _binding: FragmentDetailedCBinding? = null
    private val binding get() = _binding!!
    private val contactViewModel: ContactListViewModel by viewModel(named(CONTACT_VIEW_MODEL))
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailedCBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getContactData =
            arguments?.getParcelable<ContactData>(DETAILED_FRAGMENT) ?: throw NullPointerException(
                "Fragment arguments is null"
            )
        binding.run {
            fullNameEdit.setText(getContactData.fullName)
            phoneNumberEdit.setText(getContactData.phoneNumber)
            contactViewModel.checkIndex(
                ContactData(
                    fullNameEdit.text.toString(),
                    phoneNumberEdit.text.toString()
                )
            )
            saveBtn.setOnClickListener {
                val updatedData = ContactData(
                    fullNameEdit.text.toString(),
                    phoneNumberEdit.text.toString()
                )
                Log.d("CONTACT", "UPDATE - $updatedData")
                contactViewModel.updateContact(updatedData)
                findNavController().navigateUp()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val DETAILED_FRAGMENT = "DetailedFragment"
    }
}