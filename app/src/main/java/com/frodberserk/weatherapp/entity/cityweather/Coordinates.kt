package com.frodberserk.weatherapp.entity.cityweather

import android.os.Parcel
import android.os.Parcelable

/**
 * Stores geo coordinates of a location.
 *
 * @property lat Latitude.
 * @property lng Longitude.
 */
data class Coordinates(
    val lat: Double,
    val lng: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(lat)
        parcel.writeDouble(lng)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coordinates> {
        override fun createFromParcel(parcel: Parcel): Coordinates {
            return Coordinates(parcel)
        }

        override fun newArray(size: Int): Array<Coordinates?> {
            return arrayOfNulls(size)
        }
    }
}