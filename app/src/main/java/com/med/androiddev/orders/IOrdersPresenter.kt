package com.med.androiddev.orders

import com.med.domain.orders.model.Order

interface IOrdersPresenter {

    // Domain katmanına atılan siparişler isteği başarılı ise present sınıfında tetiklenir.

    fun orderListSuccess(orders: List<Order>)
}