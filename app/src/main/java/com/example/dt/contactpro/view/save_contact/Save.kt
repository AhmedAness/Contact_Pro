package com.example.dt.contactpro.view.save_contact

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.dt.contactpro.R
import com.example.dt.contactpro.databinding.ActivitySaveBinding
import com.example.dt.contactpro.model.entities.UserContact


class Save : AppCompatActivity() {
    var user = UserContact()
    private lateinit var sViewModel: SaveViewModel
    private lateinit var binding: ActivitySaveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_save)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = ""
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        sViewModel = ViewModelProvider(this).get(SaveViewModel::class.java)
        sViewModel.setActivity(this@Save)
        binding.saveActivity = this@Save
        binding.lifecycleOwner = this@Save
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.save_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.Save_Contact -> {
            if (user.name == "" ||user.name.equals(null)){
                binding.Name.error = "Valid item"
            }else if (user.phone == "" ||user.phone.equals(null)){
                binding.phone.error = "Valid item"
            }else {
                sViewModel.addContact(user)
            }
            true
        }
        else -> super.onOptionsItemSelected(item)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}