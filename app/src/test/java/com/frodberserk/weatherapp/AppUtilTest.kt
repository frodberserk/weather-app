package com.frodberserk.weatherapp

import com.frodberserk.weatherapp.util.AppUtil
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class AppUtilTest {

    /**
     * Test function for @AppUtil.kelvinToCelsius function.
     */
    @Test
    fun test_kelvinToCelsius() {
        assert(AppUtil.kelvinToCelsius(null) == 0)
        assert(AppUtil.kelvinToCelsius(273.15) == 0)
        assert(AppUtil.kelvinToCelsius(325.0) == 52)
        assert(AppUtil.kelvinToCelsius(300.65) == 28)
        assert(AppUtil.kelvinToCelsius(-325.0) == -598)
    }

    /**
     * Test function for @AppUtil.appendWithComma function.
     */
    @Test
    fun test_appendWithComma() {
        assert(AppUtil.appendWithComma("Sangrur", null).equals("Sangrur"))
        assert(AppUtil.appendWithComma("Sangrur", "").equals("Sangrur"))
        assert(AppUtil.appendWithComma("Sangrur", "IN").equals("Sangrur,IN"))
        assert(AppUtil.appendWithComma("Sangrur", "India").equals("Sangrur,India"))
    }
}