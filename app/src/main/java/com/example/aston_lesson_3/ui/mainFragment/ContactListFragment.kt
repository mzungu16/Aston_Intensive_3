package com.example.aston_lesson_3.ui.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aston_lesson_3.databinding.FragmentContactListBinding
import com.example.aston_lesson_3.di.CONTACT_VIEW_MODEL
import com.example.aston_lesson_3.domain.NavigationInt
import com.example.aston_lesson_3.ui.detailedContactFragment.DetailedCFragment.Companion.DETAILED_FRAGMENT
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class ContactListFragment : Fragment(), ContactRecyclerViewAdapter.OnContactListener {
    private var _binding: FragmentContactListBinding? = null
    private val binding get() = _binding!!
    private val contactViewModel: ContactListViewModel by viewModel(named(CONTACT_VIEW_MODEL))
    private val contactRecyclerViewAdapter = ContactRecyclerViewAdapter(this)
    private var alreadyLoaded = false
    private val controller by lazy {
        activity as NavigationInt
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null && !alreadyLoaded) {
            alreadyLoaded = true
            contactViewModel.getContactsListFromUsecase()
        }
        initRecyclerView()
        binding.run {
            contactViewModel.contactList.observe(viewLifecycleOwner) {
                contactRecyclerViewAdapter.setList(it)
            }
        }
    }

    private fun initRecyclerView() {
        binding.run {
            contactRecyclerView.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = contactRecyclerViewAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onContactClick(position: Int) {
        val contactData = contactRecyclerViewAdapter.contactListAdapter[position]
        val bundle = Bundle().apply {
            putParcelable(DETAILED_FRAGMENT, contactData)
        }
        controller.openDetailedFragment(bundle)
    }
}