package com.frodberserk.weatherapp.util

/**
 * Contains commonly used functions throughout the app.
 */
class AppUtil {

    companion object {
        /**
         * Appends two strings seperated with comma.
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
    }

}