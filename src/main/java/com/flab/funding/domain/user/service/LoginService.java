package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.model.dto.LoginRes;

import java.util.Optional;

public interface LoginService {
    void login(String loginId, String loginPw);
    void logout();
    Optional<LoginRes> getLoginInfo();

}
