package com.example.residentmanagement.model

import java.util.*

data class Debt (
    var total: Int,
    var date: Date,
    var pendingInvoices: Int,
)