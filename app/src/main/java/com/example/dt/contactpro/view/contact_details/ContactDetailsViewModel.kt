package com.example.dt.contactpro.view.contact_details

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.dt.contactpro.view.save_contact.Save

class ContactDetailsViewModel : ViewModel() {
    @SuppressLint("StaticFieldLeak")
    private lateinit var activity: Activity



    fun setActivity(context: Activity) {
        this.activity = context
    }

    fun goToSave(){
        activity.startActivity(Intent(activity, Save::class.java))
    }

}
