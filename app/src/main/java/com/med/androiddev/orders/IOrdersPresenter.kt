package com.med.androiddev.orders

import com.med.domain.network.orders.model.Order

interface IOrdersPresenter {

    // Siparişler isteği başarılı ise present sınıfında tetiklenir.
    fun orderListSuccess(orders: List<Order>)

    // Kullaniciya hata mesaji gosterilmesi icin tetiklenir.
    fun errorMessage()

    // Siparişler isteği icin present sınıfında tetiklenir.
    fun getOrderList()
}