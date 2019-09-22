package com.med.domain.network.orders.model

// Siparis Veri Transfer Modeli
data class Order(
    val date: String?,
    val marketName: String?,
    val month: String?,
    val orderName: String?,
    val productDetail: ProductDetail?,
    val productPrice: Double?,
    val productState: String?
)

// Ürün Detayı Veri Transfer Modeli
data class ProductDetail(
    val orderDetail: String?,
    val summaryPrice: Double?
)