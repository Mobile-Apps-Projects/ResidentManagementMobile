package com.example.residentmanagement.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.residentmanagement.databinding.FragmentProfileBinding
import com.example.residentmanagement.view.LoginActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    //Views models


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.signOut.setOnClickListener {
            Firebase.auth.signOut()
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }


        return binding.root
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}