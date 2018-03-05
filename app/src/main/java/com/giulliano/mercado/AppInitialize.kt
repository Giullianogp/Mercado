package com.giulliano.mercado

import android.app.Activity
import android.app.Application
import android.content.Context
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector

import javax.inject.Inject


/**
 * Created by Giulliano on 28/02/2018.
 */

class AppInitialize : Application(), HasActivityInjector {
    @Inject
    var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    var context: Context? = null

    override fun onCreate() {
        super.onCreate()
        this.initDagger()
        context = applicationContext
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

    private fun initDagger() {
        DaggerAppComponent.builder().application(this).build().inject(this)
    }

}
