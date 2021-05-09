package com.example.dt.contactpro.view.save_contact

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.dt.contactpro.model.entities.UserContact
import com.google.firebase.firestore.FirebaseFirestore
import java.sql.DatabaseMetaData

class SaveViewModel : ViewModel() {
    @SuppressLint("StaticFieldLeak")
    private lateinit var activity: Activity
    private lateinit var database: FirebaseFirestore
    private var TAG ="ahmed"



    fun setActivity(context: Activity) {
        this.activity = context
        database= FirebaseFirestore.getInstance()
    }

    fun addContact(user: UserContact){
        database.collection("Contacts").add(user).addOnSuccessListener{documentReference->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            Toast.makeText(activity, "Done", Toast.LENGTH_SHORT).show()
        } .addOnFailureListener { e ->
            Log.w(TAG, "Error adding document", e)
            Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
        }
    }


}
