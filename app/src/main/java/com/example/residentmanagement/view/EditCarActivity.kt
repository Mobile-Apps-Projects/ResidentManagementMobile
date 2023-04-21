package com.example.residentmanagement.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.residentmanagement.databinding.ActivityEditCarBinding

class EditCarActivity : AppCompatActivity() {
    private val binding by lazy { ActivityEditCarBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.saveCarBT2.setOnClickListener {
            finish()

        }


    }
}