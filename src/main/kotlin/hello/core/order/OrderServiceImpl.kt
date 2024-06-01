package hello.core.order

import hello.core.discount.DiscountPolicy
import hello.core.discount.FixDiscountPolicy
import hello.core.discount.RateDiscountPolicy
import hello.core.member.MemoryMemberRepository

class OrderServiceImpl : OrderService {

    private val memberRepo = MemoryMemberRepository()


    override fun createOrder(
        memberId: Long,
        itemName: String,
        itemPrice: Int,
        discountPolicy: DiscountPolicy,
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