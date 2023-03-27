package com.example.residentmanagement.view.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.residentmanagement.databinding.FragmentReserveBinding


class ReserveFragment : Fragment() {

    private lateinit var binding: FragmentReserveBinding

    //Views models


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentReserveBinding.inflate(inflater, container, false)


        return binding.root
    }

    companion object {
        fun newInstance() = ReserveFragment()
    }
}