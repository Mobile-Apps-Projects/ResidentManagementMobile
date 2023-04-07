package com.example.residentmanagement.view.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.residentmanagement.R

class NotificationVH(root: View): RecyclerView.ViewHolder(root){

    var title: TextView = root.findViewById(R.id.titleNotification)
    var description: TextView = root.findViewById(R.id.descriptionNotification)
    var time: TextView = root.findViewById(R.id.timeNotification)
}