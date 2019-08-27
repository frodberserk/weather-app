package com.frodberserk.weatherapp.view.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

/**
 * Base activity which other activities will inherit.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        //Toolbar added for the activities.
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