package hello.core

import hello.core.member.Grade
import hello.core.member.Member
import hello.core.member.MemberServiceImpl
import hello.core.order.OrderServiceImpl

fun main() {
    val memberService = MemberServiceImpl()
    val orderService = OrderServiceImpl()

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