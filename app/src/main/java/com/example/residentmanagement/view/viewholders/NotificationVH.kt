package com.example.residentmanagement.view.viewholders

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.residentmanagement.R
import com.example.residentmanagement.databinding.NotificationBinding

class NotificationVH(root: View): RecyclerView.ViewHolder(root){

    private val binding:NotificationBinding = NotificationBinding.bind(root)

    var title: TextView = binding.titleNotification
    var description: TextView = binding.descriptionNotification
    var time: TextView = binding.timeNotification
    var detailButton:ImageButton = binding.detailButton

}