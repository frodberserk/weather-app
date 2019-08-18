package com.frodberserk.weatherapp.web

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.httpGet

/**
 * This class can be used to access Open Weather API. It provides various methods to make connection
 * to the API. It uses FUEL library for making connections.
 */
class WeatherApi {

    companion object {
        private const val BASE_URL = "http://api.openweathermap.org/data/2.5"   //Base Url for Open Weather API
        private const val PATH_WEATHER = "/weather"                             //Path for the weather info
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
        return PATH_WEATHER.httpGet(listOf("q" to cityParam))
    }

}