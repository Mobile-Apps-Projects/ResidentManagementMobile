package com.example.residentmanagement.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.residentmanagement.R
import com.example.residentmanagement.model.Notification
import com.example.residentmanagement.view.MainActivity
import com.example.residentmanagement.view.dialogs.NotificationDialog
import com.example.residentmanagement.view.viewholders.NotificationVH

class NotificationAdapter : RecyclerView.Adapter<NotificationVH>() {
    var notifications = ArrayList<Notification>()

    init {
        notifications.add(Notification("Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min","administación"))
        notifications.add(Notification("Corte de GAS", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min","APTO403"))
        notifications.add(Notification("Corte de luz", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min","APTO403"))
        notifications.add(Notification("Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min","administación"))
        notifications.add(Notification("Corte de GAS", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min","APTO403"))




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notification, parent, false)
        return NotificationVH(view)
    }

    override fun onBindViewHolder(holder: NotificationVH, position: Int) {
        holder.title.text = notifications[position].title
        holder.description.text = notifications[position].description
        holder.time.text = notifications[position].time
        holder.detailButton.setOnClickListener {
            //Open dialog fragment
            val fragmentManager = (holder.itemView.context as AppCompatActivity).supportFragmentManager
            NotificationDialog(notifications[position]).show(fragmentManager, "notification_dialog")
        }

    }

    override fun getItemCount(): Int {
        return notifications.size
    }
}