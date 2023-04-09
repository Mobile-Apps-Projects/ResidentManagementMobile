package com.example.residentmanagement.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.residentmanagement.databinding.ActivityLoginBinding
import com.example.residentmanagement.model.User

class LoginActivity : AppCompatActivity() {

    private var alpha: String? = null
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //XML --> Kotlin
        setContentView(binding.root)

        binding.signin.setOnClickListener {
            val usernameValue = binding.username.text.toString()
            val passwordValue = binding.password.text.toString()

            Toast.makeText(this, "Username: $usernameValue, Password: $passwordValue", Toast.LENGTH_LONG).show()

            //Change to other activity with parameters
            val intent = Intent(this, MainActivity::class.java)

            intent.apply {
                putExtra("username", usernameValue)
            }
            startActivity(intent)
        }

        showText("Hello World"){
            Log.d(">>>", it)
        }

        val user = User("John", 20, "juan@gmail.com", "1234", "1234567890")
    }

    fun showText(message:String,action:(String)->Unit){
        action(message)
    }
}