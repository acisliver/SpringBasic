package com.example.springbasic.controller;

import com.example.springbasic.MemberForm;
import com.example.springbasic.domain.Member;
import com.example.springbasic.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 스프링 컨테이너에 컨트롤러 등록 (컴포넌트 스캔)
public class MemberController {

    // 여기에 @Autowired를 하면 필드 주입
    // final이여서 스프링 컨테이너 실행 시에만 동작하고 바꿀 수 없다.
    private final MemberService memberService;

    // setter 주입
    // setter가 public하게 노출되어 변경의 위험이 존재
    // public void setMemberService

    // 스프링이 서비스를 DI
    // 생성자 주입 - 권장
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";
    }
}
