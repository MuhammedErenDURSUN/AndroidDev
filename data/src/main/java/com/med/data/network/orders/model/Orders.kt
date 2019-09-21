package com.med.data.network.orders.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// Siparis Modeli
data class Order(
    @SerializedName("date")
    @Expose
    var date: String? = null,
    @SerializedName("month")
    @Expose
    var month: String? = null,
    @SerializedName("marketName")
    @Expose
    var marketName: String? = null,
    @SerializedName("orderName")
    @Expose
    var orderName: String? = null,
    @SerializedName("productPrice")
    @Expose
    var productPrice: Double? = null,
    @SerializedName("productState")
    @Expose
    var productState: String? = null,
    @SerializedName("productDetail")
    @Expose
    var productDetail: ProductDetail? = null

)

// Ürün Detayı Modeli
data class ProductDetail(

    @SerializedName("orderDetail")
    @Expose
    var orderDetail: String? = null,
    @SerializedName("summaryPrice")
    @Expose
    var summaryPrice: Double? = null

)