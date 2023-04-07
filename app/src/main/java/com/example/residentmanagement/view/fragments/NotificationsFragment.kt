package com.example.residentmanagement.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.residentmanagement.R
import com.example.residentmanagement.databinding.FragmentHomeBinding
import com.example.residentmanagement.databinding.FragmentNotificationsBinding
import com.example.residentmanagement.view.adapters.NotificationAdapter


class NotificationsFragment : Fragment() {

    private lateinit var binding: FragmentNotificationsBinding

    //Adapters
    private val adapter = NotificationAdapter()

    //Views models


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false)

        //RecyclerView
        binding.notificationsList.adapter = adapter
        binding.notificationsList.setHasFixedSize(true)
        binding.notificationsList.layoutManager = LinearLayoutManager(activity)

        binding.filterButton.setOnClickListener {
            Toast.makeText(activity, "Filter", Toast.LENGTH_SHORT).show()
        }


        return binding.root
    }

    companion object {
        fun newInstance() = NotificationsFragment()
    }
}