package com.example.residentmanagement.view.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.residentmanagement.databinding.DialogNotificationBinding
import com.example.residentmanagement.model.Notification
import java.text.SimpleDateFormat

class NotificationDialog(private val notification: Notification) : DialogFragment() {

    private lateinit var binding: DialogNotificationBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogNotificationBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireActivity())

        //Set all the data
        binding.title.text = notification.titulo
        binding.description.text = notification.contenido
//        binding.time.text =
        val timestamp =notification.date.toDate()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
        binding.time.text = dateFormat.format(timestamp)
        binding.from.text = "Enviado desde: " + notification.src

        builder.setView(binding.root)

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

}