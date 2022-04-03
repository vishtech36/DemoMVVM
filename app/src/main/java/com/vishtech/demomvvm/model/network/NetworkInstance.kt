package com.vishtech.demomvvm.model.network

import com.vishtech.demomvvm.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    val api: AirlineApi by lazy {
        retrofit.create(AirlineApi::class.java)
    }
}