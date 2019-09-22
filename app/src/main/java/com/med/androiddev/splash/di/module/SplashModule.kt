package com.med.androiddev.splash.di.module

import com.med.androiddev.di.scope.PerActivity
import com.med.androiddev.splash.SplashPresenter
import com.med.domain.preferences.login.ClearPreferenceUseCase
import com.med.domain.preferences.login.GetPreferenceUseCase
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @PerActivity
    @Provides
    internal fun provideSplashPresenter(getPreferenceUseCase: GetPreferenceUseCase,clearPreferenceUseCase: ClearPreferenceUseCase) =
        SplashPresenter(getPreferenceUseCase,clearPreferenceUseCase)
}