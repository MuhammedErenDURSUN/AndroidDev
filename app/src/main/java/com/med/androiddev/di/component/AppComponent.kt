package com.med.androiddev.di.component

import android.content.Context
import com.med.androiddev.App
import com.med.androiddev.di.module.AppModule
import com.med.androiddev.di.module.IOModule
import com.med.androiddev.di.module.RepositoryModule
import com.med.androiddev.di.module.UseCaseModule
import com.med.data.network.Endpoint
import com.med.domain.network.orders.OrderListUseCase
import com.med.domain.preferences.login.ClearPreferenceUseCase
import com.med.domain.preferences.login.EditPreferenceUseCase
import com.med.domain.preferences.login.GetPreferenceUseCase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, IOModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
    fun inject(app: App)
    fun getApplicationContext(): Context
    fun getEndpoint(): Endpoint
    fun orderListUseCase(): OrderListUseCase
    fun getPreferenceUseCase(): GetPreferenceUseCase
    fun editPreferenceUseCase(): EditPreferenceUseCase
    fun clearPreferenceUseCase(): ClearPreferenceUseCase
}
