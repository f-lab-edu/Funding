package com.flab.funding.domain.user.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Builder
public class User {

    // pk
    private Long id;

    // 회원 아이디
    private String userId;

    // 회원 비밀번호
    private String password;

    // 회원 이름
    private String userName;

    // 회원 이메일
    private String email;

    // 회원 연락처
    private String phone;

    // 회원 주소 - 시
    private String si;

    // 회원 주소 - 구
    private String gu;

    // 회원 주소 - 동
    private String dong;

    // 회원 주소 - 상세주소
    private String address;

    // 회원 역할 (판매자, 구매자)
    private UserRole userRole;
}
