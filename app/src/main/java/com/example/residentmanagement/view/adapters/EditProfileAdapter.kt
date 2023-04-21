package com.example.residentmanagement.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.residentmanagement.R
import com.example.residentmanagement.model.ItemProfile
import com.example.residentmanagement.view.viewholders.ItemProfileVH

class EditProfileAdapter : RecyclerView.Adapter<ItemProfileVH>() {
    var items = ArrayList<ItemProfile>()

    init {
        items.add(ItemProfile("Alex Sanchez",1))
        items.add(ItemProfile("Jacobo Garcia",1))
        items.add(ItemProfile("Martin Perez",1))
        items.add(ItemProfile("Juan Fernando",1))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemProfileVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
        return ItemProfileVH(view)
    }

    override fun onBindViewHolder(holder: ItemProfileVH, position: Int) {
        holder.title.text = items[position].title
        holder.icon.setOnClickListener {
            //Open intent to edit
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}