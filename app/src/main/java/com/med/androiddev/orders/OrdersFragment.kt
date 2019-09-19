package com.med.androiddev.orders

import android.util.Log
import com.med.androiddev.App
import com.med.androiddev.R
import com.med.androiddev.base.BaseFragment
import com.med.androiddev.orders.di.component.DaggerOrdersComponent
import com.med.domain.orders.model.Order

class OrdersFragment : BaseFragment<OrdersPresenter>(), OrdersView {

    // View'ın hangi layouttan oluşacağını belirler.

    override fun getLayout(): Int = R.layout.fragment_orders

    // View'ı Component'e inject eder.

    override fun initInjector() {
        DaggerOrdersComponent.builder()
            .appComponent((context!!.applicationContext as App).applicationComponent)
            .build()
            .inject(this)
    }

    // Present tarafından View ilk oluşturulma durumunda tetiklenir.

    override fun initialiseView() {

    }

    // Siparişler isteği başarılı ise present tarafından siparişlerin listelenmesi için tetiklenir.

    override fun orderList(orders: List<Order>) {
        Log.i("Orders", orders.toString())
    }

}