package com.med.androiddev.di.module

import com.med.data.network.Endpoint
import com.med.data.network.orders.repository.OrdersRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    internal fun provideOrdersRepository(endpoint: Endpoint): OrdersRepository =
        OrdersRepository(endpoint)

}