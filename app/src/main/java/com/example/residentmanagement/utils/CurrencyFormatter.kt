package com.example.residentmanagement.utils

import java.text.NumberFormat
import java.util.*

object CurrencyFormatter {
    fun formatCurrency(amount: Int): String {
        val currencyFormat: NumberFormat = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
        return currencyFormat.format(amount.toLong())
    }
}
