package hello.core

import hello.core.discount.FixDiscountPolicy
import hello.core.discount.RateDiscountPolicy
import hello.core.member.Grade
import hello.core.member.Member
import hello.core.member.MemberServiceImpl
import hello.core.member.MemoryMemberRepository
import hello.core.order.OrderServiceImpl

fun main() {
    val appConfig = AppConfig()
    val memberService = appConfig.memberService()
    val orderService = appConfig.orderService()

    val memberId = 1L
    val member = Member(
        id = memberId,
        name = "memberA",
        grade = Grade.VIP,
    )
    memberService.join(member)

    val order = orderService.createOrder(
        memberId = memberId,
        itemName = "itemA",
        itemPrice = 10000,
    )

    println("order = $order")
    println("order.calculatePrice = ${order.calculatePrice()}")
}