package com.example.jetpackdemo.main_ViewModel

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.jetpackdemo.databinding.ActivityMainBinding
import com.example.jetpackdemo.lifeCycles.LifeCyclesActivity
import com.example.jetpackdemo.liveData.LiveDataActivity
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        private const val TAG = "MainActivity"
    }

    private val sp:SharedPreferences by lazy {
        getSharedPreferences("app", Context.MODE_PRIVATE)
    }

//    private val viewModelWithOutInit:MainViewModel by viewModels()

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(sp.getInt("count",0))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {

            viewModel.counterLiveData.observe(this@MainActivity){
                tvCount.text=it.toString()
            }

            btAdd.setOnClickListener {
                lifecycleScope.launch {
                   viewModel.plusOne()
                }
            }

            btClear.setOnClickListener {
               viewModel.clear()
            }

            btLifeCycles.setOnClickListener {
                LifeCyclesActivity.startActivity(this@MainActivity)
            }

            btLiveData.setOnClickListener {
                LiveDataActivity.startActivity(this@MainActivity)
            }

        }
    }

    override fun onPause() {
        super.onPause()
        sp.edit().putInt("count",viewModel.counterLiveData.value?:0).apply()
    }
}