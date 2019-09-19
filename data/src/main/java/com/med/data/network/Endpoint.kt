package com.med.data.network

import com.med.data.network.orders.model.Order
import io.reactivex.Single
import retrofit2.http.GET

interface Endpoint {

    // Retrofit Get isteğininin atılacağı url ve Json verisini, sipariş modelini liste olarak döndürür.

    @GET("/")
    fun getOrderList(): Single<List<Order>>
}