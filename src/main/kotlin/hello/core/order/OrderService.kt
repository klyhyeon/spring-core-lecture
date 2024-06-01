package hello.core.order

import hello.core.discount.DiscountPolicy

interface OrderService {

    fun createOrder(
        memberId: Long,
        itemName: String,
        itemPrice: Int,
        discountPolicy: DiscountPolicy,
    ): Order
}