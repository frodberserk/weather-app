package com.frodberserk.weatherapp

import com.frodberserk.weatherapp.web.WeatherImageUtil
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class WeatherApiImageTest {

    @Test
    fun test_getWeatherImageUrl() {
        print(WeatherImageUtil.getWeatherImageUrl("01n"))
        assert(WeatherImageUtil.getWeatherImageUrl("01n").equals("http://openweathermap.org/img/wn/01n@2x.png"))
    }

}