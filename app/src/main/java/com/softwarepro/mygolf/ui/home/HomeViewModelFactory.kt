package com.softwarepro.mygolf.ui.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.softwarepro.mygolf.database.CourseDataDatabaseDao
import com.softwarepro.mygolf.database.RoundDataDatabaseDao
import com.softwarepro.mygolf.database.UserDataDatabaseDao
import java.lang.IllegalArgumentException

class HomeViewModelFactory(
        private val userDataSource: UserDataDatabaseDao,
        private val courseDatabase: CourseDataDatabaseDao,
        private val gameDatabase: RoundDataDatabaseDao,
        private val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(userDataSource, courseDatabase, gameDatabase, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}