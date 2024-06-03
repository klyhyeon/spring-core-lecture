package hello.core

import hello.core.discount.FixDiscountPolicy
import hello.core.member.MemberService
import hello.core.member.MemberServiceImpl
import hello.core.member.MemoryMemberRepository
import hello.core.order.OrderService
import hello.core.order.OrderServiceImpl

// 공연기획자
class AppConfig {

    fun memberService(): MemberService = MemberServiceImpl(memberRepository())

    fun orderService(): OrderService = OrderServiceImpl(
        memberRepo = memberRepository(),
        discountPolicy = discountPolicy(),
    )

    private fun memberRepository() = MemoryMemberRepository()

    private fun discountPolicy() = FixDiscountPolicy()
}