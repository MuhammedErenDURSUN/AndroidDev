package com.med.androiddev.login.activity.di.module

import com.med.androiddev.di.scope.PerActivity
import com.med.androiddev.login.activity.LoginActivityPresenter
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @PerActivity
    @Provides
    internal fun provideLoginActivityPresenter() = LoginActivityPresenter()
}