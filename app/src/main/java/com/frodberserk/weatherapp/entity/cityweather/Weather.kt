package com.frodberserk.weatherapp.entity.cityweather

import android.os.Parcel
import android.os.Parcelable

/**
 * Stores weather conditions of a location.
 *
 * @property id Weather condition id
 * @property main Weather title
 * @property description Weather description
 * @property icon ID of weather icon
 */
data class Weather(
    val id: Int,
    val main: String?,
    val description: String?,
    val icon: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(main)
        parcel.writeString(description)
        parcel.writeString(icon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Weather> {
        override fun createFromParcel(parcel: Parcel): Weather {
            return Weather(parcel)
        }

        override fun newArray(size: Int): Array<Weather?> {
            return arrayOfNulls(size)
        }
    }
}