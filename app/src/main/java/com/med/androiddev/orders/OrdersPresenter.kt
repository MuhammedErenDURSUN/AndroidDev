package com.med.androiddev.orders

import android.view.View
import com.med.androiddev.R
import com.med.androiddev.base.BasePresenter
import com.med.domain.network.orders.OrderListUseCase
import com.med.domain.network.orders.model.Order
import javax.inject.Inject

class OrdersPresenter @Inject constructor(private val orderListUseCase: OrderListUseCase) :
    BasePresenter<OrdersView>(), IOrdersPresenter {


    override fun getOrderList() {
        // Sipariş listesinin belirlenen modelde getirilmesi için atılan istek.
        orderListUseCase.execute(OrderListSingleObserver(this), null)
    }

    // Observer tarafından siparişler isteği başarılı ise tetiklenir.
    override fun orderListSuccess(orders: List<Order>) {


        // Siparişler isteğinden yanit geldiginde yukleniyor simgesini gizler.
        getView()?.showProgressBar(View.GONE)

        // Siparişlerin listelenmesi için tetiklenir.
        getView()?.orderList(orders)
    }


    override fun initialise() {

        getView()?.initialiseView()

        // Siparişler isteğinden yanit beklenirken yukleniyor simgesini gosterir.
        getView()?.showProgressBar(View.VISIBLE)

        // Sipariş listesinin belirlenen modelde getirilmesi için atılan istek.
        getOrderList()
    }

    override fun disposeSubscriptions() {}

    override fun errorMessage() {
        getView()?.showAlert(R.string.error_message)
    }
}
