package com.softwarepro.mygolf.ui.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.softwarepro.mygolf.database.entities.UserDao
import java.lang.IllegalArgumentException

class HomeViewModelFactory(
        private val userDataSource: UserDao,
        private val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(userDataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}