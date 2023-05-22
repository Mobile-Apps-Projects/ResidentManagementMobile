package com.example.residentmanagement.model

import java.io.Serializable
import java.util.Date

data class Invoice (
    var id: String,
    var concepto: String,
    var date: Date,
    var valor: Long
    ): Serializable {
    constructor():this("","", Date(), 0)
}
