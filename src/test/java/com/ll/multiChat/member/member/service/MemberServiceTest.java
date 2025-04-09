package com.ll.multiChat.member.member.service;

import com.ll.multiChat.domain.member.member.service.MemberService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;
//    @DisplayName("회원가입")
//    @Test
//    void t1() {
//        RsData<Member> joinRs = memberService.join("usernew", "1234");
//        Member member = joinRs.getData();
//        assertThat(member.getId()).isGreaterThan(0L);
//    }
}