package min.community.service;

import lombok.RequiredArgsConstructor;
import min.community.dao.Member;
import min.community.dao.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    @Transactional
    public void update(Long id, String pw) {
        Member member = memberRepository.findById(id).get();
        member.setPw(pw);
    }

    public Member findOne(Long id) {
        return memberRepository.findById(id).get();

    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
}
