package com.med.androiddev.splash.di.component

import com.med.androiddev.di.component.AppComponent
import com.med.androiddev.di.scope.PerActivity
import com.med.androiddev.splash.SplashActivity
import com.med.androiddev.splash.di.module.SplashModule
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [SplashModule::class])
interface SplashComponent {
    fun inject(splashActivity: SplashActivity)
}