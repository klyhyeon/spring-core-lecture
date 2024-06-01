package hello.core.order

import hello.core.member.Grade
import hello.core.member.Member
import hello.core.member.MemberServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OrderServiceTest {

    val memberService = MemberServiceImpl()
    val orderService = OrderServiceImpl()

    @Test
    fun createOrder() {
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
        assertThat(order.discountPrice).isEqualTo(1000)
    }
}