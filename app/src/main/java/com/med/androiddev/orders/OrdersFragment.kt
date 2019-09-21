package com.med.androiddev.orders

import androidx.recyclerview.widget.LinearLayoutManager
import com.med.androiddev.App
import com.med.androiddev.R
import com.med.androiddev.base.BaseFragment
import com.med.androiddev.orders.di.component.DaggerOrdersComponent
import com.med.domain.network.orders.model.Order
import kotlinx.android.synthetic.main.fragment_orders.*

class OrdersFragment : BaseFragment<OrdersPresenter>(), OrdersView {

    // Yukleniyor simgesini gosterir veya gizler.
    override fun showProgressBar(visibility: Int) {
        ordersProgressBar.apply {
            this.visibility = visibility
        }
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

        ordersRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = OrdersAdapter(context, emptyList())
        }
    }

    // Siparişler isteği başarılı ise present tarafından siparişlerin listelenmesi için tetiklenir.
    override fun orderList(orders: List<Order>) {

        ordersRecyclerView.apply {
            adapter = OrdersAdapter(context, orders)
        }
    }

}