package com.example.residentmanagement.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.residentmanagement.databinding.ActivityEditProfileBinding
import com.example.residentmanagement.view.adapters.EditProfileAdapter

class EditProfileActivity : AppCompatActivity() {

    private val binding by lazy { ActivityEditProfileBinding.inflate(layoutInflater) }

    //Adapters
    private val adapter = EditProfileAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //RecyclerView
        binding.itemList.adapter = adapter
        binding.itemList.setHasFixedSize(true)
        binding.itemList.layoutManager = LinearLayoutManager(this)

        val title = intent.getStringExtra("fragment")

        binding.toolbar.title = title

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}