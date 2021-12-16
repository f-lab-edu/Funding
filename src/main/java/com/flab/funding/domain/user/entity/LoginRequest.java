package com.flab.funding.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {

    // 로그인 아이디
    private String loginId;

    // 로그인 패스워드
    private String loginPw;
}
