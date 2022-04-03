package com.vishtech.demomvvm.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vishtech.demomvvm.model.data.Airline

@Database(entities = [Airline::class], version = 1, exportSchema = false)
abstract class AirlineDatabase: RoomDatabase() {

    abstract fun airlineDao(): AirlineDao

    companion object{

        @Volatile
        private var INSTANCE: AirlineDatabase? = null

        fun getDatabase(ctx: Context) : AirlineDatabase {
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(ctx.applicationContext,
                    AirlineDatabase::class.java,
                    "airline_db"
                    ).build()
                INSTANCE = instance
                return instance
            }
        }

    }

}