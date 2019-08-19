package com.frodberserk.weatherapp.view.activities

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

/**
 * Base activity which other activities will inherit.
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * Toolbar added for the activities.
     */
    override fun onStart() {
        super.onStart()
        setSupportActionBar(getToolbarInstance())
    }

    /**
     * Abstract function which will return the toolbar needed to add to the activity.
     * This method will be implemented by the derived activities.
     *
     * @return Returns the toolbar object.
     */
    abstract fun getToolbarInstance(): Toolbar?

}