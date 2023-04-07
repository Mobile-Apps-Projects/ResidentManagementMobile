package com.example.residentmanagement.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.residentmanagement.R
import com.example.residentmanagement.model.Notification
import com.example.residentmanagement.view.viewholders.NotificationVH

class NotificationAdapter : RecyclerView.Adapter<NotificationVH>() {
    var notifications = ArrayList<Notification>()

    init {
        notifications.add(Notification("Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min"))
        notifications.add(Notification("Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min"))
        notifications.add(Notification("Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min"))
        notifications.add(Notification("Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min"))
        notifications.add(Notification("Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min"))
        notifications.add(Notification("Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min"))
        notifications.add(Notification("Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min"))
        notifications.add(Notification("Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min"))
        notifications.add(Notification("Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min"))
        notifications.add(Notification("Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", "10 min"))


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notification, parent, false)
        return NotificationVH(view)
    }

    override fun onBindViewHolder(holder: NotificationVH, position: Int) {
        holder.title.text = notifications[position].title
        holder.description.text = notifications[position].description
        holder.time.text = notifications[position].time
    }

    override fun getItemCount(): Int {
        return notifications.size
    }
}