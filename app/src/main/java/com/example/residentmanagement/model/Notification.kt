package com.example.residentmanagement.model

import com.google.firebase.Timestamp
import java.time.LocalDateTime
import java.util.Date

data class Notification (
    val id:String,
    val titulo:String,
    val contenido:String,
    val date:Timestamp,
    val dest:String,
    val src:String
){
    constructor() : this("", "", "", Timestamp(Date()), "", "")
}