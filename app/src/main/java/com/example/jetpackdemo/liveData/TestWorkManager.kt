package com.example.jetpackdemo.liveData

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.*

class TestWorkManager(context: Context,params: WorkerParameters):CoroutineWorker(context,params) {

    companion object{
        private const val TAG = "TestWorkManager"
    }

    override suspend fun doWork(): Result = coroutineScope{

        val age= withContext(Dispatchers.IO) {
            delay(2000)
            (0..10000).random()
        }
        Log.d(TAG, "doWork: $age")

        Result.success()
    }

}