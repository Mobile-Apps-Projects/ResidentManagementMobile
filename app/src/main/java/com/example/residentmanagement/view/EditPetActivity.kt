package com.example.residentmanagement.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.residentmanagement.databinding.ActivityEditPetBinding

class EditPetActivity : AppCompatActivity() {
    private val binding by lazy { ActivityEditPetBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}