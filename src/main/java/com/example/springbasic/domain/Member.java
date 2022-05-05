package com.example.springbasic.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id         // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 자동 생성
    private Long id;

//    @Column(name = "username")  DB에 저장될 컬럼명
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
