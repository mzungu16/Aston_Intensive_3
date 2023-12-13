package com.example.aston_lesson_3.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.aston_lesson_3.R
import com.example.aston_lesson_3.databinding.ActivityMainBinding
import com.example.aston_lesson_3.domain.NavigationInt
import com.example.aston_lesson_3.ui.addContactFragment.AddContactDirections

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener,
    NavigationInt {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        binding.run {
            findNavController(R.id.nav_host_fragment_container).addOnDestinationChangedListener(this@MainActivity)
            fabBtnClicked()
        }
    }

    private fun fabBtnClicked() {
        binding.run {
            btnAddContact.setOnClickListener {
                navigateToAddContact()
            }
        }
    }

    private fun navigateToAddContact() {
        val directions = AddContactDirections.actionGlobalAddContactFragment()
        findNavController(R.id.nav_host_fragment_container).navigate(directions)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.contactListFragment -> {
                binding.run {
                    btnAddContact.show()
                }
            }

            R.id.addContactFragment -> {
                binding.run {
                    Toast.makeText(this@MainActivity, "ADD", Toast.LENGTH_SHORT).show()
                    btnAddContact.hide()
                }
            }

            R.id.detailedCFragment -> {
                binding.run {
                    btnAddContact.hide()
                }
            }
        }
    }

    override fun openDetailedFragment(bundle: Bundle) {
        val navOptions = NavOptions.Builder()
            .setPopUpTo(R.id.detailedCFragment, false)
            .setLaunchSingleTop(true)
            .build()
        findNavController(R.id.nav_host_fragment_container).navigate(
            R.id.detailedCFragment,
            bundle,
            navOptions
        )
    }
}