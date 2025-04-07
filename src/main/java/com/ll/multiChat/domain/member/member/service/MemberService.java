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
        Member member = new Member();

        member.setUsername(username);
        member.setPassword(passwordEncoder.encode(password));

        memberRepository.save(member);

        return member;
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }
}
