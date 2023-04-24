package com.example.residentmanagement.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.residentmanagement.databinding.FragmentProfileBinding
import com.example.residentmanagement.view.EditProfileActivity
import com.example.residentmanagement.view.LoginActivity
import com.example.residentmanagement.viewmodel.LoginViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    //Views models
    //View model
    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.signOut.setOnClickListener {
            viewModel.signOut()
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        binding.carsButton.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            intent.putExtra("fragment", "VEHICULOS")
            startActivity(intent)
        }

        binding.petsButton.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            intent.putExtra("fragment", "MASCOTAS")
            startActivity(intent)
        }

        binding.residentButton.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            intent.putExtra("fragment", "RESIDENTES")
            startActivity(intent)
        }


        return binding.root
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}