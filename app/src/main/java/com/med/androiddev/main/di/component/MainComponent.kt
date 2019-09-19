package com.med.androiddev.main.di.component

import com.med.androiddev.di.component.AppComponent
import com.med.androiddev.di.scope.PerActivity
import com.med.androiddev.main.MainActivity
import com.med.androiddev.main.di.module.MainModule
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [MainModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}