package com.example.jetpackdemo.lifeCycles

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver(val lifecycle:Lifecycle) : LifecycleObserver {

    companion object{
        private const val TAG = "MyObserver"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart(){
        Log.d(TAG, "activityStart: ")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun activityPause(){
        Log.d(TAG, "activityPause: ")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop(){
        Log.d(TAG, "activityStop: ")
    }

}