package com.example.residentmanagement.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.residentmanagement.R
import com.example.residentmanagement.databinding.ActivityMainBinding
import com.example.residentmanagement.view.fragments.HomeFragment
import com.example.residentmanagement.view.fragments.NotificationsFragment
import com.example.residentmanagement.view.fragments.ProfileFragment
import com.example.residentmanagement.view.fragments.ReserveFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    //Fragments
    private val homeFragment: HomeFragment = HomeFragment.newInstance()
    private val contentFragment: ReserveFragment = ReserveFragment.newInstance()
    private val configFragment: ProfileFragment = ProfileFragment.newInstance()
    private val notificationsFragment: NotificationsFragment = NotificationsFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bottomNavigator.setOnItemSelectedListener { option: MenuItem ->
            when (option.itemId) {
                R.id.home -> showFragment(homeFragment)
                R.id.reserve -> showFragment(contentFragment)
                R.id.profile -> showFragment(configFragment)
            }
            true
        }

        binding.toolbar.setOnMenuItemClickListener { option: MenuItem ->
            when (option.itemId) {
                R.id.notifications -> showFragment(notificationsFragment)
            }
            true
        }
        showFragment(homeFragment)

    }


    private fun showFragment(fragment: Fragment?) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container, fragment!!)
        transaction.commit()
    }
}