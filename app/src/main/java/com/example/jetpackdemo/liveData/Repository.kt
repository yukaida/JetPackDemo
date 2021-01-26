package com.example.jetpackdemo.liveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object Repository {

    fun getUser(userId:String):LiveData<User>{
        val liveData=MutableLiveData<User>()
        liveData.value = User(userId, "$userId+123", 10)
        return liveData
    }



}