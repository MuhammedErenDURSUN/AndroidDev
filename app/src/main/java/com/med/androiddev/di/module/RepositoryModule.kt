package com.med.androiddev.di.module

import android.content.Context
import com.med.data.network.Endpoint
import com.med.data.network.orders.repository.OrdersRepository
import com.med.data.preferences.login.repository.PreferenceRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    internal fun provideOrdersRepository(endpoint: Endpoint): OrdersRepository =
        OrdersRepository(endpoint)

    @Provides
    @Singleton
    internal fun providePreferenceRepository(context: Context): PreferenceRepository =
        PreferenceRepository(context)
}