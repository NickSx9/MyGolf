package com.softwarepro.mygolf.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.softwarepro.mygolf.R
import com.softwarepro.mygolf.database.*

class HomeFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application
        val userDatabase = UserDataDatabase.getInstance(application).userDataDatabaseDao
        val courseDatabase = CourseDataDatabase.getInstance(application).courseDataDatabaseDao
        val gameDatabase = RoundDataDatabase.getInstance(application).roundDataDatabaseDao
        val viewModelFactory = HomeViewModelFactory(userDatabase,courseDatabase, gameDatabase,application)
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