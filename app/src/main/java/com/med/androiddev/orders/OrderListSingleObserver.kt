package com.med.androiddev.orders

import com.med.domain.network.orders.model.Order
import io.reactivex.observers.DisposableSingleObserver

//Siparişler isteğinin sonucunda tetiklenir.
class OrderListSingleObserver(private val presenter: OrdersPresenter) :
    DisposableSingleObserver<List<Order>>() {

    // Siparişler isteği başarılı ise tetiklenir.
    override fun onSuccess(orders: List<Order>) {

        // present sınıfında view güncellenmesi için tetiklenir.
        presenter.orderListSuccess(orders)
    }

    // Siparişler isteği başarısız ise tetiklenir.
    override fun onError(e: Throwable) {
        presenter.errorMessage()
        e.printStackTrace()
    }
}
