package hello.core.member

class MemoryMemberRepository : MemberRepository{

    companion object {
        private val store: MutableMap<Long, Member> = mutableMapOf()
    }

    override fun save(member: Member) {
        store[member.id] = member
    }

    override fun findById(memberId: Long): Member? {
        return store[memberId]
    }
}