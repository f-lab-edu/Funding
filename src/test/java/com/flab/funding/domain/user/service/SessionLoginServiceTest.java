package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.infrastructure.SessionAuthentication;
import com.flab.funding.domain.user.exception.FailedLoginException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SessionLoginServiceTest {

    LoginService loginService = new UserLoginService(new SessionAuthentication());

    @DisplayName("로그인 성공")
    @Test
    void loginSuccessTest() {
        Assertions.assertTrue(loginService.login("testId", "12345678"));
    }

    @DisplayName("로그인 실패")
    @Test
    void loginFailTest() {
        Assertions.assertThrows(FailedLoginException.class, () -> loginService.login("testId", "111"));
    }
}
