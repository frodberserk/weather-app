package com.frodberserk.weatherapp.entity.cityweather

import android.os.Parcel
import android.os.Parcelable

/**
 * Stores sunrise and sunset times.
 *
 * @property country Country code
 * @property sunrise Time of sunrise in millis, UTC.
 * @property sunset Time of sunset in millis, UTC.
 */
data class SunTime(
    val country: String?,
    val sunrise: Long,
    val sunset: Long
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readLong(),
        parcel.readLong()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(country)
        parcel.writeLong(sunrise)
        parcel.writeLong(sunset)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SunTime> {
        override fun createFromParcel(parcel: Parcel): SunTime {
            return SunTime(parcel)
        }

        override fun newArray(size: Int): Array<SunTime?> {
            return arrayOfNulls(size)
        }
    }
}