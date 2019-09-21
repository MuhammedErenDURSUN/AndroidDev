package com.med.data.network.orders.repository

import com.med.data.network.Endpoint
import com.med.data.network.orders.model.Order
import io.reactivex.Single
import javax.inject.Inject

class OrdersRepository @Inject constructor(private val endpoint: Endpoint) {

    // Retrofit Get isteginden gelen Json verisinin, Gson kütüphanesi ile parse edilmiş sipariş modelinin, listesini döndürür.
    fun getOrderList(): Single<List<Order>> = endpoint.getOrderList().map { it }
}