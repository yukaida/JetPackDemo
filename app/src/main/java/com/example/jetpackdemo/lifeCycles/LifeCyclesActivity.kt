package com.example.jetpackdemo.lifeCycles

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import com.example.jetpackdemo.R

class LifeCyclesActivity : AppCompatActivity() {

    companion object{
        fun startActivity(context:Context){
            context.startActivity(Intent(context, LifeCyclesActivity::class.java))
        }
    }

    private val myObserver=MyObserver(lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycles)
        lifecycle.addObserver(myObserver)

        lifecycle.currentState

    }
}