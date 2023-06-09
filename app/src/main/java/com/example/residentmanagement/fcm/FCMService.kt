package com.example.residentmanagement.fcm

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import com.example.residentmanagement.model.Notification
import edu.co.icesi.firestoreejemplokotlin.util.NotificationUtil
import org.json.JSONObject

class FCMService : FirebaseMessagingService() {


    override fun onMessageReceived(message: RemoteMessage) {
        val obj = JSONObject(message.data as Map<*, *>)
        val json = obj.toString()
        val notification = Gson().fromJson(json, Notification::class.java)
        NotificationUtil.showNotification(this, notification.titulo, notification.contenido)
    }
}