package com.med.androiddev.login.fragment.di.module

import com.med.androiddev.di.scope.PerActivity
import com.med.androiddev.login.fragment.LoginFragmentPresenter
import com.med.domain.preferences.login.EditPreferenceUseCase
import dagger.Module
import dagger.Provides

@Module
class LoginFragmentModule {
    @PerActivity
    @Provides
    internal fun provideLoginFragmentPresenter(editPreferenceUseCase: EditPreferenceUseCase) =
        LoginFragmentPresenter(editPreferenceUseCase)
}