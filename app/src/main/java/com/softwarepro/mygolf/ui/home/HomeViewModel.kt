package com.softwarepro.mygolf.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softwarepro.mygolf.database.entities.UserDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel(val userDatabase: UserDao,
                    application: Application) : ViewModel() {

    init {

    }

    private val _text = MutableLiveData<String>().apply {
        value = "Last Game Results"
    }
    val text: LiveData<String> = _text


    suspend fun checkLastRecordedGame() {
     
    }
}
//    suspend fun checkDetails(email: String, password: String) {
//        if(email != "" && password != ""){
//            viewModelScope.launch {
//                authentication(email,password).await()
//            }
//        }
//    }
//    private  fun authentication(email: String, password: String) = GlobalScope.async {
//        var details = userDataDao.findUserDetails(email, password)
//        if(details.emailAddress != ""){
//            authenticated = true
//            Thread.sleep(100)
//        }
//    }
//    fun registerNewDetails(name: String, email: String, password: String){
//        var userData = UserData(firstName = name, emailAddress = email, password = password)
//        viewModelScope.launch {
//            insertNew(userData)
//        }
//    }
//    private suspend fun insertNew(userData: UserData){
//        userDataDao.insert(userData)
//    }

