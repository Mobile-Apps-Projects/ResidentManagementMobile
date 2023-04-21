package com.example.residentmanagement.view.viewholders

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.residentmanagement.R
import com.example.residentmanagement.databinding.ItemProfileBinding
import com.example.residentmanagement.databinding.NotificationBinding

class ItemProfileVH(root: View): RecyclerView.ViewHolder(root){

    private val binding:ItemProfileBinding = ItemProfileBinding.bind(root)

     var title: TextView = binding.name
     var icon: ImageButton = binding.icon






}