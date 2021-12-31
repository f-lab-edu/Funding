package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.entity.LoginedUser;

import java.util.Optional;

public interface LoginService {
    boolean login(String loginId, String loginPw);
    void logout();
    Optional<LoginedUser> getLoginInfo();

}
