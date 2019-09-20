package com.med.androiddev.orders

import androidx.recyclerview.widget.LinearLayoutManager
import com.med.androiddev.App
import com.med.androiddev.R
import com.med.androiddev.base.BaseFragment
import com.med.androiddev.orders.di.component.DaggerOrdersComponent
import com.med.domain.orders.model.Order
import kotlinx.android.synthetic.main.fragment_orders.*

class OrdersFragment : BaseFragment<OrdersPresenter>(), OrdersView {

    // Yukleniyor simgesini gosterir veya gizler.

    override fun showProgressBar(viewType: Int) {
        if (orderProgressBar != null)
            orderProgressBar.visibility = viewType
    }

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

        orderRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = OrdersAdapter(context!!, List(0) { null } as List<Order>)
        }
    }

    // Siparişler isteği başarılı ise present tarafından siparişlerin listelenmesi için tetiklenir.

    override fun orderList(orders: List<Order>) {
        if (orderRecyclerView != null) {
            orderRecyclerView.adapter = OrdersAdapter(context!!, orders)
        }
    }

}