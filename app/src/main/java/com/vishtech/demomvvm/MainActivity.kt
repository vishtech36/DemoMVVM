package com.vishtech.demomvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.asLiveData
import com.vishtech.demomvvm.model.data.Airline
import com.vishtech.demomvvm.viewmodel.MainViewModel
import com.vishtech.demomvvm.viewmodel.MainViewModelFactory

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as AirlineApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.airlineList.asLiveData().observe(this) {
            Log.d(TAG, "DB : $it")
        }
    }
}