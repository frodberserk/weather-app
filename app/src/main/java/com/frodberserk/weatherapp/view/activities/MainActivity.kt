package com.frodberserk.weatherapp.view.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.frodberserk.weatherapp.MainContract
import com.frodberserk.weatherapp.R
import com.frodberserk.weatherapp.di.components.DaggerMainComponent
import com.frodberserk.weatherapp.entity.CityWeather
import com.frodberserk.weatherapp.presenter.MainPresenter
import com.frodberserk.weatherapp.util.AppUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_weather.*
import org.jetbrains.anko.inputMethodManager
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    //Views
    private val toolbar by lazy { toolbar_base }

    private val fieldCity by lazy { edittext_city }
    private val fieldCountry by lazy { edittext_country }
    private val buttonWeather by lazy { button_getweather }

    private val progressBar by lazy { progressbar_loader }

    private val viewWeather by lazy { parent_weather }
    private val labelLocation by lazy { textview_locationname }
    private val labelTemperature by lazy { textview_temperature }
    private val imageWeather by lazy { imageview_weather }
    private val labelWeather by lazy { textview_weather }

    //Presenter to be injected with dagger
    @Inject
    lateinit var presenter: MainPresenter

    //Boolean to check if activity is newly created in order to initialize presenter in onStart
    var isNewActivity = true

    override fun getToolbarInstance(): Toolbar? {
        return toolbar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inject the dependencies from MainComponent
        DaggerMainComponent.builder().build().inject(this)

        //Set the new activity flag to true
        isNewActivity = true
    }

    override fun onStart() {
        super.onStart()
        //Bind the presenter when view is ready
        presenter.bind(this)

        //Register events
        buttonWeather.setOnClickListener {
            presenter.onGetWeatherClicked(fieldCity.text.toString(), fieldCountry.text.toString())
        }

        if (isNewActivity) {
            isNewActivity = false
            presenter.initialize()
        }

    }

    override fun onStop() {
        super.onStop()

        //Unbind the presenter when view goes to the background
        presenter.unbind()

        //Unregister events
        buttonWeather.setOnClickListener(null)
    }

    /**
     * Shows a toast.
     *
     * @param message The message to display in the toast.
     */
    override fun showToast(message: String) {
        toast(message)
    }

    /**
     * Set the values in city and country fields.
     *
     * @param city City name to set in fieldCity.
     * @param country Country name to set in fieldCountry.
     */
    override fun setInput(city: String, country: String) {
        fieldCity.setText(city)
        fieldCountry.setText(country)
    }

    /**
     * Shows the progress bar and hides the weather view and soft keyboard if visible.
     */
    override fun showProgress() {
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        viewWeather.visibility = View.GONE

        progressBar.visibility = View.VISIBLE
    }

    /**
     * Hides the progress bar.
     */
    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    /**
     * Sets the weather related information in the view.
     *
     * @param data The CityWeather object which contains the weather information.
     */
    override fun showWeatherData(data: CityWeather) {

        //Makes weather view visible if its not
        viewWeather.visibility = View.VISIBLE

        //Sets the data
        labelLocation.text = data.name
        labelWeather.text = data.weather?.get(0)?.description
        labelTemperature.text = String.format(
            getString(R.string.temperature_format, AppUtil.kelvinToCelsius(data.main?.temp))
        )
    }
}