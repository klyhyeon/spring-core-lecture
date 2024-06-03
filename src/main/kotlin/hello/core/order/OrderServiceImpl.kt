package hello.core.order

import hello.core.discount.DiscountPolicy
import hello.core.member.MemberRepository

class OrderServiceImpl(
    private val memberRepo: MemberRepository,
    private val discountPolicy: DiscountPolicy,
) : OrderService {


    override fun createOrder(
        memberId: Long,
        itemName: String,
        itemPrice: Int,
    ): Order {
        val member = memberRepo.findById(memberId)!!
        val discountPrice = discountPolicy.discount(
            member = member,
            price = itemPrice,
        )
        return Order(
            memberId = member.id,
            itemName = itemName,
            itemPrice = itemPrice,
            discountPrice = discountPrice,
        )
    }
}