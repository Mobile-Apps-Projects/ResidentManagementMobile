package edu.co.icesi.firestoreejemplokotlin.util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.residentmanagement.view.MainActivity
import com.example.residentmanagement.R
// import edu.co.icesi.firestoreejemplokotlin.activites.HomeActivity

object NotificationUtil {

    private val CHANNEL_ID = "messages";
    private val CHANNEL_NAME = "Messages";
    private var id = 0;

    fun showNotification(context: Context, title:String, message:String){

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }

        val notifyIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val notifyPendingIntent = PendingIntent.getActivity(
            context, 0, notifyIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setDefaults(Notification.DEFAULT_ALL)
            .setContentText(message)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.logo)
            .setContentIntent(notifyPendingIntent)

        val notification = builder.build()
        notificationManager.notify(id, notification)
        id++
    }

}