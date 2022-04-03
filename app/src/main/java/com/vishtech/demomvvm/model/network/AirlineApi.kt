package com.vishtech.demomvvm.model.network

import com.vishtech.demomvvm.model.data.Airline
import retrofit2.Response
import retrofit2.http.GET

interface AirlineApi {
    @GET("dummy-response.json")
    suspend fun getAirlineData(): Response<List<Airline>>
}