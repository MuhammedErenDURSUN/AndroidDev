package com.med.domain.network.orders

import com.med.data.network.orders.repository.OrdersRepository
import com.med.domain.base.SingleUseCase
import com.med.domain.network.orders.model.Order
import com.med.domain.network.orders.model.ProductDetail
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

// App katmanı tarafından istek atıldığında Data katmanından Siparişlerin listesini getirir.
class OrderListUseCase @Inject constructor(
    private val ordersRepository: OrdersRepository,
    subscribeScheduler: Scheduler,
    postExecutionScheduler: Scheduler
) : SingleUseCase<List<Order>, Unit>(subscribeScheduler, postExecutionScheduler) {

    // Data katmanından Siparişlerin listesini getirir, Siparis Veri Transfer Modelini oluşturur ve listesini döndürür.
    override fun buildUseCaseSingle(params: Unit?): Single<List<Order>> {
        return ordersRepository.getOrderList().map {
            it.map { od ->
                Order(
                    date = od.date,
                    marketName = od.marketName,
                    month = od.month,
                    orderName = od.orderName,
                    productDetail = od.productDetail?.let { pd ->
                        ProductDetail(orderDetail = pd.orderDetail, summaryPrice = pd.summaryPrice)
                    },
                    productPrice = od.productPrice,
                    productState = od.productState
                )
            }
        }
    }
}