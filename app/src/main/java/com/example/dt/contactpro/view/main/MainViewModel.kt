package com.example.dt.contactpro.view.main

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dt.contactpro.model.entities.UserContact
import com.example.dt.contactpro.view.save_contact.Save
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class MainViewModel : ViewModel() {
    @SuppressLint("StaticFieldLeak")
    private lateinit var activity: Activity
    private lateinit var database: FirebaseFirestore
    private val mutablecontacts = MutableLiveData<List<UserContact>>()



    fun setActivity(context: Activity) {
        this.activity = context
        database= FirebaseFirestore.getInstance()
        getData()
    }

    fun goToSave(){
        activity.startActivity(Intent(activity, Save::class.java))
    }

    fun getData(){
         database.collection("Contacts").get().addOnCompleteListener(object :OnCompleteListener<QuerySnapshot>{
             override fun onComplete(p0: Task<QuerySnapshot>) {
                 var list = ArrayList<UserContact>()
                 if (p0.isSuccessful){
                      for (data in p0.result!!){
                          var contact = UserContact()
                          contact.name = data.get("name") as String
                          contact.phone = data.get("phone") as String
                          list.add(contact)
                      }
                     mutablecontacts.postValue(list)
                  }
             }

         })
    }

    fun getAllData(): LiveData<List<UserContact>> {
        return mutablecontacts
    }

}
