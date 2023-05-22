package com.example.residentmanagement.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.residentmanagement.model.Notification
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.util.*

class NotificationsViewModel:ViewModel() {

    private val data = arrayListOf<Notification>()
    private val _notifications = MutableLiveData(data)
    val notifications get() = _notifications

    fun getNotifications(){
        viewModelScope.launch(Dispatchers.Main) {
            val currentUserUID = Firebase.auth.currentUser!!.uid

            val query = Firebase.firestore
                .collection("apartamentos").document(currentUserUID).collection("mensajes")
                .get().await()

            Log.d(">>>","test log")
            query.forEach { document ->
                val data = document.data
                data.forEach { (field, value) ->
                    Log.d("TAG", "$field: $value")
                }
                Log.d("TAG", "-------------------")
            }

            for (change in query.documentChanges){
                if(change.type == DocumentChange.Type.ADDED) {
                    val notification = change.document.toObject(Notification::class.java)
                    data.add(notification)
                    withContext(Dispatchers.Main){
                        _notifications.value = data
                    }
                }
            }
        }
    }

}