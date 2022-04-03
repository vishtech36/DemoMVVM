package com.vishtech.demomvvm.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vishtech.demomvvm.model.data.Airline
import kotlinx.coroutines.flow.Flow

@Dao
interface AirlineDao {

    @Query("select * from airline")
    fun getAirlineList(): Flow<List<Airline>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(airline: Airline)

    @Insert
    suspend fun insertAll(airline: Array<out Airline>)

}