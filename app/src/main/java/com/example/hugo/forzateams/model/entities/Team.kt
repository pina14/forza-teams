package com.example.hugo.forzateams.model.entities

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by Hugo on 02/02/2018.
 */
class Team(
        @SerializedName("name") val teamName : String,
        @SerializedName("national") val isNationalTeam : Boolean,
        @SerializedName("country_name") val teamCountry : String) : Parcelable{

    constructor(parcel: Parcel) : this(parcel.readString(),parcel.readByte() != 0.toByte(), parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(teamName)
        parcel.writeByte(if (isNationalTeam) 1 else 0)
        parcel.writeString(teamCountry)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Team> {
        override fun createFromParcel(parcel: Parcel): Team {
            return Team(parcel)
        }

        override fun newArray(size: Int): Array<Team?> {
            return arrayOfNulls(size)
        }
    }

}