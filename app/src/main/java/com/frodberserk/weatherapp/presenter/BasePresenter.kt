package com.frodberserk.weatherapp.presenter

/**
 *  Abstract class for base presenter. Each presenter will inherit this class.
 *  V is the class type of the view bound to a presenter.
 */
abstract class BasePresenter<V> {

    //View object bound to the presenter.
    protected var view: V? = null

    /**
     * Binds the view to the presenter.
     *
     * @param view The view to be bind to presenter.
     */
    fun bind(view: V) {
        this.view = view
    }

    /**
     * Unbinds the view from the presenter.
     */
    fun unbind() {
        view = null
    }
}