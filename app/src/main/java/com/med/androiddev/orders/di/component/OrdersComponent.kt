package com.med.androiddev.orders.di.component

import com.med.androiddev.di.component.AppComponent
import com.med.androiddev.di.scope.PerActivity
import com.med.androiddev.orders.OrdersFragment
import com.med.androiddev.orders.di.module.OrdersModule
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [OrdersModule::class])
interface OrdersComponent {
    fun inject(ordersFragment: OrdersFragment)
}