package com.example.springbasic.repository;

import com.example.springbasic.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    // 생성자 주입
    public JpaMemberRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> resultList = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return resultList.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // 객체(Entity)를 대상으로 쿼리를 보냄
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
