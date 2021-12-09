package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.infrastructure.SessionAuthentication;
import com.flab.funding.domain.user.exception.FailedLoginException;
import com.flab.funding.domain.user.repository.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SessionLoginServiceTest {

    @Mock
    UserMapper userMapper;

    @Mock
    SessionAuthentication authentication;

    @InjectMocks
    UserLoginService loginService;

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
