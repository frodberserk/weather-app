package com.frodberserk.weatherapp.interactor

import com.frodberserk.weatherapp.MainContract
import com.frodberserk.weatherapp.entity.CityWeather
import com.frodberserk.weatherapp.web.WeatherApi
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.result.Result

class MainInteractor : MainContract.Interactor {
    override fun fetchWeather(
        city: String,
        country: String?,
        output: (result: Result<CityWeather, FuelError>) -> Unit
    ) {
        WeatherApi.getCityWeatherRequest(city, country).responseObject<CityWeather> { _, _, result ->
            output(result)

        }
    }
}