package hello.core.member

import hello.core.AppConfig
import hello.core.order.OrderService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MemberServiceTest {

    private lateinit var memberService: MemberService

    @BeforeEach
    fun setUp() {
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
    }

    @Test
    fun join() {
        // given
        val member = Member(
            id = 1L,
            name = "memberA",
            grade = Grade.VIP,
        )

        // when
        memberService.join(member)
        val findMember = memberService.findMember(1L)

        // then
        assertThat(member).isEqualTo(findMember)
    }
}