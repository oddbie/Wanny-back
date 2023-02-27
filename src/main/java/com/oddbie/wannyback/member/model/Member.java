package com.oddbie.wannyback.member.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@Table(name = "member")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 60)
    private String pw;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public Member(String email, String pw, String name, String phone, UserRole role) {
        this.email = email;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.role = role;
    }
}