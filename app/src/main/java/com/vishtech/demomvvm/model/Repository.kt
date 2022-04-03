package com.vishtech.demomvvm.model

import com.vishtech.demomvvm.model.data.Airline
import com.vishtech.demomvvm.model.database.AirlineDao
import com.vishtech.demomvvm.model.network.NetworkInstance
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class Repository(private val dao: AirlineDao) {


    val airlineList: Flow<List<Airline>> = dao.getAirlineList()

    suspend fun getAirlineData(): Response<List<Airline>> {
        return NetworkInstance.api.getAirlineData()
    }

    suspend fun insert(airline: Airline) {
        dao.insert(airline);
    }

    suspend fun insertAll(airline: Array<out Airline>) {
        dao.insertAll(airline)
    }

}