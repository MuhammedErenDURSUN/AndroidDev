package com.med.androiddev.di.module

import com.med.data.network.orders.repository.OrdersRepository
import com.med.data.preferences.login.repository.PreferenceRepository
import com.med.domain.network.orders.OrderListUseCase
import com.med.domain.preferences.login.ClearPreferenceUseCase
import com.med.domain.preferences.login.EditPreferenceUseCase
import com.med.domain.preferences.login.GetPreferenceUseCase
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

    @Provides
    @Singleton
    internal fun provideGetPreferenceUseCase(
        preferenceRepository: PreferenceRepository, @Named("ioScheduler") ioScheduler: Scheduler, @Named(
            "mainThreadScheduler"
        ) mainThreadScheduler: Scheduler
    ): GetPreferenceUseCase =
        GetPreferenceUseCase(preferenceRepository, ioScheduler, mainThreadScheduler)

    @Provides
    @Singleton
    internal fun provideEditPreferenceUseCase(
        preferenceRepository: PreferenceRepository, @Named("ioScheduler") ioScheduler: Scheduler, @Named(
            "mainThreadScheduler"
        ) mainThreadScheduler: Scheduler
    ): EditPreferenceUseCase =
        EditPreferenceUseCase(preferenceRepository, ioScheduler, mainThreadScheduler)

    @Provides
    @Singleton
    internal fun provideClearPreferenceUseCase(
        preferenceRepository: PreferenceRepository, @Named("ioScheduler") ioScheduler: Scheduler, @Named(
            "mainThreadScheduler"
        ) mainThreadScheduler: Scheduler
    ): ClearPreferenceUseCase =
        ClearPreferenceUseCase(preferenceRepository, ioScheduler, mainThreadScheduler)
}
