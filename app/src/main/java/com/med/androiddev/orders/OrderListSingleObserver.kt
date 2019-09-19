package com.med.androiddev.orders

import android.util.Log
import com.med.domain.orders.model.Order
import io.reactivex.observers.DisposableSingleObserver

// Domain katmanına atılan siparişler isteğinin sonucunda tetiklenir.

class OrderListSingleObserver(private val presenter: OrdersPresenter) :
    DisposableSingleObserver<List<Order>>() {

    // Domain katmanına atılan siparişler isteği başarılı ise tetiklenir.

    override fun onSuccess(orders: List<Order>) {

        // present sınıfında view güncellenmesi için tetiklenir.

        presenter.orderListSuccess(orders)
    }

    // Domain katmanına atılan siparişler isteği başarısız ise tetiklenir.

    override fun onError(e: Throwable) {
        Log.i("Orders", e.message)
        e.printStackTrace()
    }
}
