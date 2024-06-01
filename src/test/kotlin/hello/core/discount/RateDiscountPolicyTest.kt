package hello.core.discount

import hello.core.member.Grade
import hello.core.member.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RateDiscountPolicyTest {

    val rateDiscountPolicy = RateDiscountPolicy()

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    fun vip_o() {
        // given
        val member = Member(
            id = 1L,
            name = "memberVIP",
            grade = Grade.VIP,
        )

        // when
        val discountPrice = rateDiscountPolicy.discount(
            member = member, price = 10000
        )

        // then
        assertThat(discountPrice).isEqualTo(1000L)
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용되지 않아야 한다")
    fun vip_x() {
        // given
        val member = Member(
            id = 2L,
            name = "memberVIP",
            grade = Grade.BASIC,
        )

        // when
        val discountPrice = rateDiscountPolicy.discount(
            member = member, price = 10000
        )

        // then
        assertThat(discountPrice).isEqualTo(0L)
    }
}