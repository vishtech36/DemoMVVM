package com.vishtech.demomvvm

import android.app.Application
import android.util.Log
import com.vishtech.demomvvm.model.Repository
import com.vishtech.demomvvm.model.database.AirlineDatabase

private const val TAG = "AirlineApplication"


class AirlineApplication: Application() {

    private val database by lazy {
        AirlineDatabase.getDatabase(this)
    }

    val repository by lazy {
        Repository(database.airlineDao())
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Application created")
    }
}