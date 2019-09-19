package com.med.androiddev.orders

import com.med.androiddev.base.BasePresenter
import com.med.domain.orders.OrderListUseCase
import com.med.domain.orders.model.Order
import javax.inject.Inject

class OrdersPresenter @Inject constructor(private val orderListUseCase: OrderListUseCase) :
    BasePresenter<OrdersView>(), IOrdersPresenter {

    // Observer tarafından siparişler isteği başarılı ise tetiklenir.

    override fun orderListSuccess(orders: List<Order>) {

        // Siparişlerin listelenmesi için tetiklenir.

        getView()?.orderList(orders)
    }


    override fun initialise() {

        getView()?.initialiseView()

        // Domain katmanına sipariş listesinin belirlenen modelde getirilmesi için atılan istek.

        orderListUseCase.execute(OrderListSingleObserver(this), null)
    }

    override fun disposeSubscriptions() {

        // Sipariş modelinin temizlenmesi için atılan istek.

        orderListUseCase.dispose()
    }
}
