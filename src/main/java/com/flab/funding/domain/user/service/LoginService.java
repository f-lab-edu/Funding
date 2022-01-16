package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.model.LoginedUser;

import java.util.Optional;

public interface LoginService {
    void login(String loginId, String loginPw);
    void logout();
    Optional<LoginedUser> getLoginInfo();

}
