package com.example.springbasic.repository;

import com.example.springbasic.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository를 상속받은 인터페이스가 있는 경우
// Spring Data JPA가 구현체를 자동으로 생성해 빈으로 등록한다
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPA 네이밍 규칙에 의해 쿼리가 자동으로 작성된다
    // select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
