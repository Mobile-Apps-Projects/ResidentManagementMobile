package com.example.residentmanagement.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.residentmanagement.R
import com.example.residentmanagement.databinding.ActivityMainBinding
import com.example.residentmanagement.view.fragments.HomeFragment
import com.example.residentmanagement.view.fragments.NotificationsFragment
import com.example.residentmanagement.view.fragments.ProfileFragment
import com.example.residentmanagement.view.fragments.ReserveFragment
import com.example.residentmanagement.viewmodel.LoginViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    //Fragments
    private val homeFragment: HomeFragment = HomeFragment.newInstance()
    private val contentFragment: ReserveFragment = ReserveFragment.newInstance()
    private val configFragment: ProfileFragment = ProfileFragment.newInstance()
    private val notificationsFragment: NotificationsFragment = NotificationsFragment.newInstance()

    //View model
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.auth.observe(this) {
            if (it == 0) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        viewModel.getAuthState()

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
                R.id.back -> showFragment(notificationsFragment)
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