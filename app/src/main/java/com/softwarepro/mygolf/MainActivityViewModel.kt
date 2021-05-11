package com.softwarepro.mygolf

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.softwarepro.mygolf.database.*
import kotlinx.coroutines.launch

class MainActivityViewModel(app: Application): AndroidViewModel(app) {
    val userDataDao = UserDataDatabase.getInstance(getApplication()).userDataDatabaseDao
    val courseDatabaseDao = CourseDataDatabase.getInstance(getApplication()).courseDataDatabaseDao
    val roundDataDatabaseDao = RoundDataDatabase.getInstance(getApplication()).roundDataDatabaseDao
    val bookingDataDatabaseDao = BookingDataDatabase.getInstance(getApplication()).bookingDataDatabaseDao
    init{

    }
    fun checkDetails(email: String, password: String) : Boolean{
        var isRecordFound = true

        return isRecordFound
    }
    private suspend fun authentication(email: String, password: String):Boolean{
        var isRecordFound = false

        return isRecordFound
    }
    fun registerNewDetails(name: String, email: String, password: String){
        var userData = UserData(firstName = name, emailAddress = email, password = password)
        viewModelScope.launch {
            insertNew(userData)
        }
    }
    private suspend fun insertNew(userData: UserData){
        userDataDao.insert(userData)
    }
}