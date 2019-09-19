package com.med.androiddev.di.module

import com.med.data.network.orders.repository.OrdersRepository
import com.med.domain.orders.OrderListUseCase
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    @Named("ioScheduler")
    internal fun provideIoScheduler() = Schedulers.io()

    @Provides
    @Singleton
    @Named("mainThreadScheduler")
    internal fun provideMainThreadScheduler() = AndroidSchedulers.mainThread()

    @Provides
    @Singleton
    internal fun provideOrderListUseCase(
        ordersRepository: OrdersRepository, @Named("ioScheduler") ioScheduler: Scheduler, @Named(
            "mainThreadScheduler"
        ) mainThreadScheduler: Scheduler
    ): OrderListUseCase =
        OrderListUseCase(ordersRepository, ioScheduler, mainThreadScheduler)

}
