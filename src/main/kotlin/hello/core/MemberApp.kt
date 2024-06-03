package hello.core

import hello.core.member.Grade
import hello.core.member.Member
import hello.core.member.MemberServiceImpl
import hello.core.member.MemoryMemberRepository

fun main() {
    val appConfig = AppConfig()
    val memberService = appConfig.memberService()
    val member = Member(
        id = 1L,
        name = "memberA",
        grade = Grade.VIP,
    )
    memberService.join(member)

    val findMember = memberService.findMember(1L)
    println("new member = ${member.name}")
    println("find member = ${findMember.name}")
}

