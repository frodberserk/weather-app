package com.frodberserk.weatherapp.presenter

import com.frodberserk.weatherapp.MainContract
import com.frodberserk.weatherapp.entity.CityWeather
import com.frodberserk.weatherapp.interactor.MainInteractor
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.result.Result
import javax.inject.Inject

/**
 * Presenter class for MainActivity. Implements MainContract.Presenter interface.
 *
 * @param view Instance of MainContract.View.
 */
class MainPresenter @Inject constructor() : BasePresenter<MainContract.View>(), MainContract.Presenter,
    MainContract.InteractorOutput {

    //Interactor
    var interactor = MainInteractor()

    /**
     * Initializes the view.
     */
    override fun initialize() {

        //Initial weather location
        val initCity = "Sangrur"
        val initCountry = "India"

        //Set the location in the view's input fields
        view?.setInput(initCity, initCountry)

        //Fetch weather details for initial location
        onGetWeatherClicked(initCity, initCountry)
    }

    /**
     * Called when users presses the button to get the weather. Validates the input and calls interactor to fetch
     * weather data. If data is invalid, shows a toast message in the view.
     *
     * @param city City name of the location.
     * @param country Country name of the location.
     */
    override fun onGetWeatherClicked(city: String?, country: String?) {
        //Validate fields
        if (city != null && city != "") {
            //Show the loader
            view?.showProgress()

            //Fetch data from interactor
            interactor.fetchWeather(city, country) { result ->

                //Hide loader
                view?.hideProgress()

                when (result) {
                    //Successfully fetched weather data
                    is Result.Success -> onQuerySuccess(result.get())
                    //Failed to fetch data
                    else -> {
                        result.component2()?.exception?.printStackTrace()
                        onQueryError(result.component2())
                    }
                }
            }
        } else {
            //Invalid input, show error message
            view?.showToast("City cannot be empty")
        }
    }

    //Interactor Output methods

    /**
     * Called when query to fetch weather info is successful.
     *
     * @param cityWeather Object containing weather information.
     */
    override fun onQuerySuccess(cityWeather: CityWeather) {
        view?.showWeatherData(cityWeather)
    }

    /**
     * Called when query to fetch weather info is unsuccessful.
     *
     * @param error Fuel error returned from API call.
     */
    override fun onQueryError(error: FuelError?) {
        view?.showToast(error?.message ?: "Some error occurred")
    }

}