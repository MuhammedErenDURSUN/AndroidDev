package com.med.androiddev

import android.app.Application
import com.med.androiddev.di.component.AppComponent
import com.med.androiddev.di.component.DaggerAppComponent
import com.med.androiddev.di.module.AppModule

class App : Application() {
    val applicationComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        initInjector()
    }

    private fun initInjector() {
        applicationComponent.inject(this)
    }
}