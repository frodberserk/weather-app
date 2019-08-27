package com.frodberserk.weatherapp

import com.frodberserk.weatherapp.entity.CityWeather
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.result.Result

/**
 * Interface class which contains VIPER components for MainActivity.
 */
interface MainContract {

    /**
     * View component.
     */
    interface View {

        /**
         * Shows a toast message.
         *
         * @param message The message to display in the toast.
         */
        fun showToast(message: String)

        /**
         *Sets the input in the view.
         *
         * @param city The city name to be set in city edittext.
         * @param country The country name to be set in country edittext.
         */
        fun setInput(city: String, country: String)

        /**
         * Shows progress loader.
         */
        fun showProgress()

        /**
         * Hides progress loader.
         */
        fun hideProgress()

        /**
         * Sets the weather related information in the view.
         *
         * @param data The CityWeather object which contains the weather information.
         */
        fun showWeatherData(data: CityWeather)

    }

    /**
     * Presenter component.
     */
    interface Presenter {

        /**
         * Initializes the view.
         */
        fun initialize()

        /**
         * Handles the event of clicking get weather button.
         *
         * @param city The city input in edittext.
         * @param country The country input in edittext.
         */
        fun onGetWeatherClicked(city: String?, country: String?)
    }

    /**
     * Interactor component.
     */
    interface Interactor {
        /**
         * Fetches the weather information from Open Weather API.
         *
         * @param city Name of city.
         * @param country Name of country.
         * @param output Lambda function to return the output.
         */
        fun fetchWeather(city: String, country: String?, output: (result: Result<CityWeather, FuelError>) -> Unit)
    }

    /**
     * Interactor output component. Will be implemented by presenter to receive output from interactor.
     */
    interface InteractorOutput {

        /**
         * When the query to fetch data is successful.
         *
         * @param cityWeather Object containing weather information.
         */
        fun onQuerySuccess(cityWeather: CityWeather)

        /**
         * When the query to fetch data is unsuccessful.
         *
         * @param error FuelError object returned from API call.
         */
        fun onQueryError(error: FuelError?)
    }

}