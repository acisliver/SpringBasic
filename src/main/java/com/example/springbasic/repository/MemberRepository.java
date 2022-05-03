package com.example.springbasic.repository;

import com.example.springbasic.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// 이 인터페이스를 구현하는 방법에 따라 DB 접근 방법이 달라진다
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
