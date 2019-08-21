package com.frodberserk.weatherapp.util

import kotlin.math.roundToInt

/**
 * Contains commonly used functions throughout the app.
 */
object AppUtil {

    //Kelvin units equivalent to 0 degree Celsius
    private const val KELVIN_CONSTANT = 273.15

    /**
     * Appends two strings separated with comma. If second string is null or empty, returns first string.
     *
     * @param s1 First string.
     * @param s2 Second string, can be null.
     */
    fun appendWithComma(s1: String, s2: String?): String {
        return when (s2) {
            null, "" ->
                //Nothing to append with s1
                s1
            else ->
                //Append the strings
                "$s1,$s2"
        }
    }

    /**
     * Converts kelvin temperature into celsius. Returns 0 if input temperature is null.
     *
     * @param kelvin Temperature in Kelvin.
     * @return Temperature in Celsius.
     */
    fun kelvinToCelsius(kelvin: Double?) = kelvin?.minus(KELVIN_CONSTANT)?.roundToInt() ?: 0
}