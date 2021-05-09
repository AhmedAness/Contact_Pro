package com.example.dt.contactpro.view.main.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dt.contactpro.databinding.ContactitemItemBinding
import com.example.dt.contactpro.model.entities.UserContact
import com.example.dt.contactpro.view.contact_details.ContactDetails
import com.example.dt.contactpro.view.save_contact.Save

class ContactAdapter(var context: Activity,private val items: List<UserContact>) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContactitemItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])
    inner class ViewHolder(val binding: ContactitemItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserContact) {
            binding.newcontact = item
            binding.allcard.setOnClickListener{
                val intent = Intent(context,ContactDetails::class.java)
                intent.putExtra("Contact",item)
                context.startActivity(intent)

            }
            binding.executePendingBindings()
        }
    }
}