package com.ll.multiChat.domain.member.member.service;

import com.ll.multiChat.domain.member.member.entity.Member;
import com.ll.multiChat.domain.member.member.repository.MemberRepository;
import com.ll.multiChat.global.config.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public RsData<Member>join(String username, String password){
        Member member = new Member();

        member.setUsername(username);
        member.setPassword(password);

        memberRepository.save(member);

        return RsData.of("200","%s 님 가입을 환영합니다.".formatted(username), member);
    }
}
