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
import com.google.firebase.Timestamp
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class NotificationAdapter : RecyclerView.Adapter<NotificationVH>() {
    var notifications = ArrayList<Notification>()

//    init {
//        notifications.add(Notification("1","Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", Timestamp(Date()), "apartamentos/spqO2yAWlx9w7uPuFkMZ", "apartamentos/spqO2yAWlx9w7uPuFkMZ"))
//        notifications.add(Notification("2","Corte de GAS", "El día 10 de marzo será suspendido el servicio de agua ...", Timestamp(Date()),"apartamentos/spqO2yAWlx9w7uPuFkMZ", "apartamentos/spqO2yAWlx9w7uPuFkMZ"))
//        notifications.add(Notification("3","Corte de luz", "El día 10 de marzo será suspendido el servicio de agua ...", Timestamp(Date()),"apartamentos/spqO2yAWlx9w7uPuFkMZ", "apartamentos/spqO2yAWlx9w7uPuFkMZ"))
//        notifications.add(Notification("4","Corte de agua", "El día 10 de marzo será suspendido el servicio de agua ...", Timestamp(Date()),"apartamentos/spqO2yAWlx9w7uPuFkMZ", "apartamentos/spqO2yAWlx9w7uPuFkMZ"))
//        notifications.add(Notification("5","Corte de GAS", "El día 10 de marzo será suspendido el servicio de agua ...", Timestamp(Date()),"apartamentos/spqO2yAWlx9w7uPuFkMZ", "apartamentos/spqO2yAWlx9w7uPuFkMZ"))
//    }

    fun addNotification(notification: Notification) {
        if(!notifications.contains(notification)) {
            notifications.add(notification)
            notifyItemInserted(notifications.lastIndex)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notification, parent, false)
        return NotificationVH(view)
    }

    override fun onBindViewHolder(holder: NotificationVH, position: Int) {
        holder.title.text = notifications[position].titulo
        holder.description.text = notifications[position].contenido

        val differenceInMillis = Date().time - notifications[position].date.toDate().time
        val differenceInMinutes = TimeUnit.MILLISECONDS.toMinutes(differenceInMillis)
        val time = "$differenceInMinutes min"
        holder.time.text = time
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