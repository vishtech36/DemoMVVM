package com.vishtech.demomvvm.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Airline(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @SerializedName("Flightnr") val flightnr : String? = "",
    @SerializedName("Date") val date : String? = "",
    @SerializedName("Aircraft Type") val aircraftType : String? ="",
    @SerializedName("Tail") val tail : String? ="",
    @SerializedName("Departure") val departure : String? ="",
    @SerializedName("Destination") val destination : String? ="",
    @SerializedName("Time_Depart") val time_Depart : String? = "",
    @SerializedName("Time_Arrive") val time_Arrive : String? ="",
    @SerializedName("DutyID") val dutyID : String? = "",
    @SerializedName("DutyCode") val dutyCode : String? ="",
    @SerializedName("Captain") val captain : String? ="",
    @SerializedName("First Officer") val firstOfficer :  String? ="",
    @SerializedName("Flight Attendant") val flightAttendant : String?=""
)