package com.softwarepro.mygolf.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.softwarepro.mygolf.R
import com.softwarepro.mygolf.database.*
import com.softwarepro.mygolf.database.entities.UserDatabase

class HomeFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(this.activity).application
        val userDatabase = UserDatabase.getInstance(application).userDao
        val viewModelFactory = HomeViewModelFactory(userDatabase,application)
        val homeViewModel =
                ViewModelProvider(
                        this, viewModelFactory).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}