package com.example.residentmanagement.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.residentmanagement.databinding.FragmentHomeBinding
import com.example.residentmanagement.view.PaymentActivity
import com.example.residentmanagement.view.adapters.NotificationAdapter


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    //Views models

    //Adapters
    private val adapter = NotificationAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //RecyclerView
        binding.notificationsList.adapter = adapter
        binding.notificationsList.layoutManager = LinearLayoutManager(activity)
        binding.notificationsList.setHasFixedSize(true)


        binding.paymentButton.setOnClickListener{
            val intent= Intent(activity, PaymentActivity::class.java)
            startActivity(intent)
        }

        return binding.root

    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}