package com.example.dt.contactpro.view.contact_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.dt.contactpro.R
import com.example.dt.contactpro.databinding.ActivityContactDetailsBinding
import com.example.dt.contactpro.model.entities.UserContact

class ContactDetails : AppCompatActivity() {

    private lateinit var cViewModel: ContactDetailsViewModel
    private lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact_details)

        cViewModel = ViewModelProvider(this).get(ContactDetailsViewModel::class.java)
        cViewModel.setActivity(this@ContactDetails)

        val contact = intent.getSerializableExtra("Contact") as? UserContact
        binding.contact=contact
    }
}