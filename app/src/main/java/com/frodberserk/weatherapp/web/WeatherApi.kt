package com.frodberserk.weatherapp.web

import com.frodberserk.weatherapp.util.AppUtil
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
        private const val BASE_URL_API = "http://api.openweathermap.org/data/2.5"

        //Base Url for weather images
        private const val BASE_URL_IMAGES = "http://openweathermap.org/img/wn/"
        private const val IMAGES_SUFFIX = "@2x.png"

        //API Key for Open Weather API
        private const val APPID = "ac94b4a082858e273dcd5236fc9694f1"

        //Key for appid
        private const val APPID_KEY = "appid"

        //Paths for APIs
        private const val PATH_WEATHER = "/weather"

        /**
         * Returns image url for a weather condition.
         *
         * @param id String ID of the weather condition.
         * @return Url of the image corresponding to the ID.
         */
        fun getWeatherImageUrl(id: String) = BASE_URL_IMAGES.plus(id).plus(IMAGES_SUFFIX)
    }

    init {
        //Configure Fuel Manager by adding base path
        FuelManager.instance.basePath = BASE_URL_API
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
        return PATH_WEATHER.httpGet(listOf(APPID to APPID, "q" to cityParam))
    }

}