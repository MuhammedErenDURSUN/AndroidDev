package com.med.androiddev.orders.di.module

import com.med.androiddev.di.scope.PerActivity
import com.med.androiddev.orders.OrdersPresenter
import com.med.domain.orders.OrderListUseCase
import dagger.Module
import dagger.Provides

@Module
class OrdersModule {
    @PerActivity
    @Provides
    internal fun provideOrdersPresenter(orderListUseCase: OrderListUseCase) =
        OrdersPresenter(orderListUseCase)
}