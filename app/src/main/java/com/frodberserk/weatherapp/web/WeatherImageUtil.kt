package com.frodberserk.weatherapp.web

object WeatherImageUtil {


    //Image url suffix
    private const val IMAGES_SUFFIX = "@2x.png"


    /**
     * Returns image url for a weather condition.
     *
     * @param id String ID of the weather condition.
     * @return Url of the image corresponding to the ID.
     */
    fun getWeatherImageUrl(id: String) = "${WebConfig.WEATHER_IMAGES_BASEURL}/$id$IMAGES_SUFFIX"
}