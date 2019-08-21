package com.frodberserk.weatherapp.web

object WeatherImageUtil {


    //Base Url for weather images
    private const val BASE_URL_IMAGES = "${WeatherConfig.BASE_URL}/img/wn/"
    private const val IMAGES_SUFFIX = "@2x.png"


    /**
     * Returns image url for a weather condition.
     *
     * @param id String ID of the weather condition.
     * @return Url of the image corresponding to the ID.
     */
    fun getWeatherImageUrl(id: String) = "$BASE_URL_IMAGES$id$IMAGES_SUFFIX"
}