package com.frodberserk.weatherapp.web

import com.frodberserk.weatherapp.util.AppUtil
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.httpGet

/**
 * Class to make HTTP requests to Open Weather API. It provides various methods to fetch data
 * from the REST API using FUEL library.
 */

object WeatherApi {

    //Paths for APIs
    private const val PATH_WEATHER = "/weather"

    //Keys
    private const val KEY_APP_ID = "appid"
    private const val KEY_QUERY = "q"

    init {
        //Configure Fuel Manager by adding base path
        FuelManager.instance.basePath = WebConfig.WEATHER_API_BASEURL
    }

    /**
     * Returns the GET request for fetching city weather json data.
     *  @param city Name of city
     *  @param country Name of country
     *  @return Request object for the http call.
     */
    fun getCityWeatherRequest(city: String, country: String = ""): Request {
        //Append the city and country name
        val cityParam = AppUtil.appendWithComma(city, country)
        //Pass the param into api and return the request object
        return PATH_WEATHER.httpGet(listOf(KEY_APP_ID to WebConfig.APP_ID, KEY_QUERY to cityParam))
    }

}