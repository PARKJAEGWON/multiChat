package com.ll.multiChat.domain.member.member.controller;

import com.ll.multiChat.domain.member.member.dto.MemberDto;
import com.ll.multiChat.domain.member.member.dto.MemberRequest;
import com.ll.multiChat.domain.member.member.entity.Member;
import com.ll.multiChat.domain.member.member.service.MemberService;
import com.ll.multiChat.global.config.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class ApiV1MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    public RsData<MemberDto> join(@Valid @RequestBody MemberRequest memberRequest){
        Member member = memberService.join(memberRequest.getUsername(), memberRequest.getPassword());
        return new RsData<>("200","회원가입 성공",new MemberDto(member));
    }

    @PostMapping("login")
    public void login(){

    }

    @GetMapping("/logout")
    public void logout(){

    }

    @GetMapping("/me")
    public void me(){

    }







}
