package com.frodberserk.weatherapp.di.components

import com.frodberserk.weatherapp.di.modules.MainModule
import com.frodberserk.weatherapp.presenter.MainPresenter
import com.frodberserk.weatherapp.view.activities.MainActivity
import dagger.Component

/**
 * Dagger component interface for MainActivity.
 */
@Component(modules = [MainModule::class])
interface MainComponent {

    /**
     * Injects dependencies to the MainActivity.
     */
    fun inject(mainActivity: MainActivity)

    /**
     * Returns the MainPresenter instance.
     *
     * @return MainPresenter object.
     */
    fun getMainPresenter(): MainPresenter

}