package com.frodberserk.weatherapp.entity

import android.os.Parcel
import android.os.Parcelable
import com.frodberserk.weatherapp.entity.cityweather.*

/**
 * Stores data for city weather.
 *
 * @property coord Geo coordinates of the city
 * @property weather Weather description
 * @property main Temperature, pressure and humidity details
 * @property wind Wind details
 * @property cloud Cloud details
 * @property dt Time of weather calculation in millis
 * @property sys Sun details
 * @property timezone Shift in seconds from UTC
 * @property id City id
 * @property name City name
 * @property cod Response code of http request
 */
data class CityWeather(
    val coord: Coordinates?,
    val weather: List<Weather>?,
    val main: Details?,
    val wind: Wind?,
    val clouds: Clouds?,
    val dt: Long,
    val sys: SunTime?,
    val timezone: Long,
    val id: Long,
    val name: String?,
    val cod: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Coordinates::class.java.classLoader),
        parcel.createTypedArrayList(Weather),
        parcel.readParcelable(Details::class.java.classLoader),
        parcel.readParcelable(Wind::class.java.classLoader),
        parcel.readParcelable(Clouds::class.java.classLoader),
        parcel.readLong(),
        parcel.readParcelable(SunTime::class.java.classLoader),
        parcel.readLong(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readInt()
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(coord, flags)
        parcel.writeTypedList(weather)
        parcel.writeParcelable(main, flags)
        parcel.writeParcelable(wind, flags)
        parcel.writeParcelable(clouds, flags)
        parcel.writeLong(dt)
        parcel.writeParcelable(sys, flags)
        parcel.writeLong(timezone)
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeInt(cod)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CityWeather> {
        override fun createFromParcel(parcel: Parcel): CityWeather {
            return CityWeather(parcel)
        }

        override fun newArray(size: Int): Array<CityWeather?> {
            return arrayOfNulls(size)
        }
    }
}