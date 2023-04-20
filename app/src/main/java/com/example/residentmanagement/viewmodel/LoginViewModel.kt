package com.example.residentmanagement.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.residentmanagement.model.Auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class LoginViewModel:ViewModel(){
    private var _auth=Auth(false,"")
    val observableAuth=MutableLiveData(Auth(false,""))

    fun signIn(email:String, password:String){
        viewModelScope.launch(Dispatchers.IO) {
                try {
                    val response=Firebase.auth.signInWithEmailAndPassword(email,password).await()
                    _auth= Auth(true,"Bienvenido")

                }catch (e:Exception){
                    Log.e("LoginViewModel",e.toString())
                    _auth=Auth(false,"Error: ${e.message}")
                }
            withContext(Dispatchers.Main){
                observableAuth.value=_auth
            }
        }

    }

}