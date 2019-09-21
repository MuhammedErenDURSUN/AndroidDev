package com.med.androiddev.login.fragment.di.component

import com.med.androiddev.di.component.AppComponent
import com.med.androiddev.di.scope.PerActivity
import com.med.androiddev.login.fragment.LoginFragment
import com.med.androiddev.login.fragment.di.module.LoginFragmentModule
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [LoginFragmentModule::class])
interface LoginFragmentComponent {
    fun inject(loginFragment: LoginFragment)
}