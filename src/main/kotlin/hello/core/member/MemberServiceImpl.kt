package hello.core.member

class MemberServiceImpl(
    private val memberRepo: MemberRepository,
) : MemberService {

    override fun join(member: Member) {
        memberRepo.save(member)
    }

    override fun findMember(memberId: Long): Member {
        return memberRepo.findById(memberId) ?: throw IllegalArgumentException("member not found")
    }
}