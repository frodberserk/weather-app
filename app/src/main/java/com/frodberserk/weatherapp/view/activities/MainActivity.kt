package com.frodberserk.weatherapp.view.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.frodberserk.weatherapp.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class MainActivity : BaseActivity() {

    private val toolbar by lazy { toolbar_base }

    override fun getToolbarInstance(): Toolbar? {
        return toolbar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}