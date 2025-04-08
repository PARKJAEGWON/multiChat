package com.ll.multiChat.domain.member.member.service;

import com.ll.multiChat.domain.member.member.entity.Member;
import com.ll.multiChat.domain.member.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member join(String username, String password){

        Member checkedSignUpMember = memberRepository.findByUsername(username);

        if(checkedSignUpMember != null) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }

        Member member = new Member();

        member.setUsername(username);
        member.setPassword(passwordEncoder.encode(password));

        return  memberRepository.save(member);
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public Member getMember(String username) {
        return memberRepository.findByUsername(username);
    }
}
