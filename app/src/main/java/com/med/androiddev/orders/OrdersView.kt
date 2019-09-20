package com.med.androiddev.orders

import com.med.domain.orders.model.Order

interface OrdersView {

    // Present tarafından View ilk oluşturma durumunda tetiklenir.

    fun initialiseView()

    // Siparişler isteği başarılı ise present tarafından view güncellenmesi durumunda tetiklenir.

    fun orderList(orders: List<Order>)

    // Siparişler isteğinden yanit beklenirken tetiklenir.

    fun showProgressBar(viewType: Int)
}