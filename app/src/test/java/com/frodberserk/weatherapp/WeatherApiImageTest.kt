package com.frodberserk.weatherapp

import com.frodberserk.weatherapp.web.WeatherApi
import com.frodberserk.weatherapp.web.WeatherImageUtil
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.net.URLDecoder

@RunWith(JUnit4::class)
class WeatherApiImageTest {

    @Test
    fun test_getWeatherImageUrl() {
        WeatherImageUtil.getWeatherImageUrl("01n").let {
            println(it)
            assert(it == "https://openweathermap.org/img/wn/01n@2x.png")
        }
    }

    @Test
    fun test_getCityWeatherRequest_url() {
        URLDecoder.decode(
            WeatherApi.getCityWeatherRequest("Sangrur", "India").url.toString(),
            Charsets.UTF_8.toString()
        ).let {
            println(it)
            assert(it == "https://api.openweathermap.org/data/2.5/weather?appid=ac94b4a082858e273dcd5236fc9694f1&q=Sangrur,India")
        }

    }

}