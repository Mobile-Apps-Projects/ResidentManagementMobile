package com.example.residentmanagement.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.firestore
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class LoginViewModel:ViewModel(){

    private val _auth=MutableLiveData<Int>()
    val auth:LiveData<Int> get()=_auth
    //Firebase
    private val db = Firebase.firestore

    fun getAuthState(){
        if(Firebase.auth.currentUser!=null) {
            _auth.value = AuthState.AUTH
        }else{
            _auth.value = AuthState.NO_AUTH
        }
    }

    fun signIn(user:String, password:String){
        _auth.value=AuthState.LOADING
        var status:Int
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d(">>>",user)

                val docRef = db.collection("apartamentos").whereEqualTo("user", user)
                    .get().await()


                val email=docRef.documents[0].get("email").toString()

                Log.d(">>>",email)


                val response=Firebase.auth.signInWithEmailAndPassword(email,password).await()
                status=AuthState.AUTH

            }catch (e:Exception){
                Log.e("LoginViewModel",e.toString())
                status=AuthState.NO_AUTH
            }
            withContext(Dispatchers.Main){
                _auth.value=status
            }
        }

    }

    fun signOut(){
        Firebase.auth.signOut()
        _auth.value=AuthState.NO_AUTH
    }

}

object AuthState{
    const val NO_AUTH=0
    const val LOADING=1
    const val AUTH=2
}