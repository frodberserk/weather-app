package com.frodberserk.weatherapp.entity.cityweather

import android.os.Parcel
import android.os.Parcelable

/**
 * Stores temperature, pressure and humidity of a location.
 *
 * @property temp Current temperature in Kelvin.
 * @property pressure Atmospheric pressure at sea-level, in hPA.
 * @property humidity Humidity percentage
 * @property temp_min Minimum temperature in Kelvin.
 * @property temp_max Maximum temperature in Kelvin.
 */
data class Details(
    val temp: Double,
    val pressure: Double,
    val humidity: Int,
    val temp_min: Double,
    val temp_max: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(temp)
        parcel.writeDouble(pressure)
        parcel.writeInt(humidity)
        parcel.writeDouble(temp_min)
        parcel.writeDouble(temp_max)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Details> {
        override fun createFromParcel(parcel: Parcel): Details {
            return Details(parcel)
        }

        override fun newArray(size: Int): Array<Details?> {
            return arrayOfNulls(size)
        }
    }
}