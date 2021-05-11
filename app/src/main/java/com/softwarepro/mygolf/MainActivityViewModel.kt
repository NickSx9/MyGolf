package com.softwarepro.mygolf

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.softwarepro.mygolf.database.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivityViewModel(app: Application): AndroidViewModel(app) {
    val userDataDao = UserDataDatabase.getInstance(getApplication()).userDataDatabaseDao
    val courseDatabaseDao = CourseDataDatabase.getInstance(getApplication()).courseDataDatabaseDao
    val roundDataDatabaseDao = RoundDataDatabase.getInstance(getApplication()).roundDataDatabaseDao
    val bookingDataDatabaseDao = BookingDataDatabase.getInstance(getApplication()).bookingDataDatabaseDao
    var authenticated = false
    init{

    }
    suspend fun checkDetails(email: String, password: String) {
        if(email != "" && password != ""){
         viewModelScope.launch {
             authentication(email,password).await()
         }
        }
    }
    private  fun authentication(email: String, password: String) = GlobalScope.async {
        var details = userDataDao.findUserDetails(email, password)
        if(details.emailAddress != ""){
            authenticated = true
            Thread.sleep(100)
        }
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