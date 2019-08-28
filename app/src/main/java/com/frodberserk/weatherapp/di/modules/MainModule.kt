//package com.frodberserk.weatherapp.di.modules
//
//import com.frodberserk.weatherapp.interactor.MainInteractor
//import com.frodberserk.weatherapp.presenter.MainPresenter
//import dagger.Module
//import dagger.Provides
//
///**
// * Dagger module class for MainActivity. MainContract.View is passed through constructor.
// */
//@Module
//class MainModule {
//
//    /**
//     *  Provides the MainPresenter dependency.
//     *
//     *  @return MainPresenter instance.
//     */
//    @Provides
//    fun getMainPresenter(interactor: MainInteractor?) = MainPresenter(interactor)
//}