package com.frodberserk.weatherapp.entity.cityweather

import android.os.Parcel
import android.os.Parcelable

/**
 *Stores the speed of wind and its direction.
 *
 * @property speed Speed of wind in meters per second.
 * @property Direction of wind in degrees.
 */
data class Wind(
    val speed: Double,
    val deg: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(speed)
        parcel.writeDouble(deg)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Wind> {
        override fun createFromParcel(parcel: Parcel): Wind {
            return Wind(parcel)
        }

        override fun newArray(size: Int): Array<Wind?> {
            return arrayOfNulls(size)
        }
    }
}