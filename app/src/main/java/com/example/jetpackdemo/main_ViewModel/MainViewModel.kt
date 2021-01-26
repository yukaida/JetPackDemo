package com.example.jetpackdemo.main_ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved: Int) : ViewModel() {
//    var counter=countReserved

    val counterLiveData: LiveData<Int>
        get() = _counterLiveData

    private var _counterLiveData = MutableLiveData<Int>()

    init {
        _counterLiveData.value = countReserved
    }

    fun plusOne() {
        val counterInLiveData = _counterLiveData.value ?: 0
        _counterLiveData.value = counterInLiveData + 1
    }

    fun clear() {
        _counterLiveData.value = 0
    }


}