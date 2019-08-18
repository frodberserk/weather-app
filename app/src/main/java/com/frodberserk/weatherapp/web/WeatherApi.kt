package com.frodberserk.weatherapp.web

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.httpGet

/**
 * Class to make HTTP requests to Open Weather API. It provides various methods to fetch data
 * from the REST API using FUEL library.
 */
class WeatherApi {

    companion object {
        //Base Url for Open Weather API
        private const val BASE_URL = "http://api.openweathermap.org/data/2.5"

        //API Key for Open Weather API
        private const val APPID = "ac94b4a082858e273dcd5236fc9694f1"

        //Key for appid
        private const val APPID_KEY = "appid"

        //Paths for APIs
        private const val PATH_WEATHER = "/weather"
    }

    init {
        //Configure Fuel Manager by adding base path
        FuelManager.instance.basePath = BASE_URL
    }

    /**
     * Returns the GET request for fetching city weather json data.
     *  @param city Name of city
     *  @param country Name of country
     *  @return Request object for the http call.
     */
    fun getCityWeatherRequest(city: String, country: String = ""): Request {
        val cityParam = when (country) {
            "" -> city
            else -> "$city,$country"
        }
        return PATH_WEATHER.httpGet(listOf(APPID to APPID, "q" to cityParam))
    }

}