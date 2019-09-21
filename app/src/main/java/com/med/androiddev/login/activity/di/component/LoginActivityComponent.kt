package com.med.androiddev.login.activity.di.component

import com.med.androiddev.di.component.AppComponent
import com.med.androiddev.di.scope.PerActivity
import com.med.androiddev.login.activity.LoginActivity
import com.med.androiddev.login.activity.di.module.LoginActivityModule
import dagger.Component


@PerActivity
@Component(dependencies = [AppComponent::class], modules = [LoginActivityModule::class])
interface LoginActivityComponent {
    fun inject(loginActivity: LoginActivity)
}