package com.example.residentmanagement.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.residentmanagement.databinding.ActivityLoginBinding
import com.example.residentmanagement.viewmodel.LoginViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    //View model
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //XML --> Kotlin
        setContentView(binding.root)

        binding.signin.setOnClickListener {
            val usernameValue = binding.username.text.toString()
            val passwordValue = binding.password.text.toString()
            viewModel.signIn(usernameValue, passwordValue)
        }


        viewModel.auth.observe(this) {
            if (it==2) {
                binding.progressBar.visibility= View.GONE
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else if (it==0) {
                binding.progressBar.visibility= View.GONE
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }else{
                binding.progressBar.visibility= View.VISIBLE
            }
        }

    }

}