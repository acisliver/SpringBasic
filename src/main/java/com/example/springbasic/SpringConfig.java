package com.example.springbasic;

import com.example.springbasic.repository.MemberRepository;
import com.example.springbasic.repository.MemoryMemberRepository;
import com.example.springbasic.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 상황에 따라 구현 클래스를 변경해야할 때
// 여기서 구현 클래스만 바꿔주면 된다 - 장점
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
