package com.example.dt.contactpro.view.main

import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.dt.contactpro.R
import com.example.dt.contactpro.databinding.ActivityMainBinding
import com.example.dt.contactpro.model.entities.UserContact
import com.example.dt.contactpro.view.main.adapter.ContactAdapter
import java.util.ArrayList


class MainActivity : AppCompatActivity() {


    private lateinit var mViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private var contacts: List<UserContact> = ArrayList()
    private lateinit var contactadapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.setActivity(this@MainActivity)

        binding.mvm = mViewModel
        binding.lifecycleOwner = this@MainActivity
        setupObserver()


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val search = menu.findItem(R.id.appSearchBar)
        val searchView = search.actionView as SearchView
        searchView.queryHint = "Search"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
//                adapter.filter.filter(newText)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }


    private fun setupObserver() {
        mViewModel.getAllData().observe(this, {
            if (it != null && it.size>0) {

                contacts=it
                contactadapter = ContactAdapter(MainActivity@this,contacts)
                binding.contactAdapter = contactadapter

            } else {
                Toast.makeText(this, "Error Happened", Toast.LENGTH_LONG).show()
            }

        })
    }


}