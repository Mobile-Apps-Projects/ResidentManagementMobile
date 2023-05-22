package com.example.residentmanagement.utils

import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {
    fun formatDate(date: Date): String {
        val dateFormat = SimpleDateFormat("d 'de' MMMM 'del' yyyy", Locale("es", "ES"))
        return dateFormat.format(date)
    }
}
