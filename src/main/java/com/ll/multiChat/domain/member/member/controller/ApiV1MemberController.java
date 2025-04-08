package com.ll.multiChat.domain.member.member.controller;

import com.ll.multiChat.domain.member.member.dto.MemberDto;
import com.ll.multiChat.domain.member.member.dto.MemberRequest;
import com.ll.multiChat.domain.member.member.entity.Member;
import com.ll.multiChat.domain.member.member.service.MemberService;
import com.ll.multiChat.global.config.RsData;
import com.ll.multiChat.global.jwt.JwtProvider;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class ApiV1MemberController {
    private final MemberService memberService;
    private final JwtProvider jwtProvider;

    @PostMapping("/join")
    public RsData<MemberDto> join(@Valid @RequestBody MemberRequest memberRequest){
        Member member = memberService.join(memberRequest.getUsername(), memberRequest.getPassword());
        return new RsData<>("200","회원가입 성공",new MemberDto(member));
    }

    @PostMapping("login")
    public RsData<Void> login(@Valid @RequestBody MemberRequest memberRequest,  HttpServletResponse response){

        Member member = memberService.getMember(memberRequest.getUsername());

        // 토큰 생성
        String token = jwtProvider.genAccessToken(member);

        //응답 데이터에 accessToken 이름으로 발급
        response.addCookie(new Cookie("accessToken",token));

        return new RsData<>("200", "로그인 성공");
    }

    @GetMapping("/logout")
    public void logout(){

    }

    @GetMapping("/me")
    public void me(){

    }







}
