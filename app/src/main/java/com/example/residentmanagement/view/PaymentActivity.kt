package com.example.residentmanagement.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.residentmanagement.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private val binding by lazy { ActivityPaymentBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}