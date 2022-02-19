package com.example.springbasic.controller;

import com.example.springbasic.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 스프링 컨테이너에 컨트롤러 등록 (컴포넌트 스캔)
public class MemberController {

    private final MemberService memberService;

    // 스프링이 서비스를 DI
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
