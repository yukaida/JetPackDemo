package com.example.jetpackdemo.liveData

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.example.jetpackdemo.R
import com.example.jetpackdemo.databinding.ActivityLiveDataBinding
import com.example.jetpackdemo.databinding.ActivityMainBinding
import com.example.jetpackdemo.lifeCycles.LifeCyclesActivity

class LiveDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLiveDataBinding
    companion object {
        private const val TAG = "LiveDataActivity"
        fun startActivity(context: Context){
            context.startActivity(Intent(context, LiveDataActivity::class.java))
        }
    }


    private val viewModel=LiveDataViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {

            btGetUser.setOnClickListener {

                viewModel.getUser((0..100).random().toString())

            }

            btWm.setOnClickListener {
                val oneTimeRequest = OneTimeWorkRequest.Builder(TestWorkManager::class.java).build()
                WorkManager.getInstance(this@LiveDataActivity).enqueue(oneTimeRequest)
            }

        }

        viewModel.user.observe(this){
            binding.tvNum.text=it.firstName
        }
    }
}