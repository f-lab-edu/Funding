package com.flab.funding.domain.user.model.dto;

import com.flab.funding.domain.user.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class LoginRes {

    // 회원 아이디
    private String userId;

    // 회원 이름
    private String userName;

    // 회원 역할 (판매자, 구매자)
    private UserRole userRole;
}
