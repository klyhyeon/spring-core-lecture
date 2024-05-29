package hello.core.member

class MemberServiceImpl : MemberService {

    private val memberRepo: MemberRepository = MemoryMemberRepository()

    override fun join(member: Member) {
        memberRepo.save(member)
    }

    override fun findMember(memberId: Long): Member {
        return memberRepo.findById(memberId) ?: throw IllegalArgumentException("member not found")
    }
}