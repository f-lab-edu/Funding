package com.flab.funding.domain.user.service;

import com.flab.funding.global.constant.SessionConstant;
import com.flab.funding.global.exception.user.FailedLoginException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;

@SpringBootTest
public class SessionLoginServiceTest {

    @Autowired
    SessionLoginService loginService;
    @Autowired
    HttpSession session;

    @DisplayName("로그인 성공")
    @Test
    void loginSuccessTest() {

        loginService.login("testId", "12345678");

        Assertions.assertEquals(session.getAttribute(SessionConstant.SESSION_NAME), "홍길동");
    }

    @DisplayName("로그인 실패")
    @Test
    void loginFailTest() {

        Assertions.assertThrows(FailedLoginException.class, () -> loginService.login("testId", "111"));
    }
}
