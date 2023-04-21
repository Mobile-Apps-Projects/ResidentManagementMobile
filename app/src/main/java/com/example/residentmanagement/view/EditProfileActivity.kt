package com.example.residentmanagement.view

import android.content.Intent
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

        binding.addButton.setOnClickListener {
            var intent:Intent? =null
            when (title) {

                "MASCOTAS" -> {
                    intent = Intent(this, EditPetActivity::class.java)
                }
                "VEHICULOS" -> {
                    intent = Intent(this, EditCarActivity::class.java)
                }
                "RESIDENTES" -> {
                    intent = Intent(this, EditResidentActivity::class.java)
                }
            }
           intent?.let { startActivity(it) }

        }

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}