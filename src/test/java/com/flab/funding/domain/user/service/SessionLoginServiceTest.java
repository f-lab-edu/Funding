package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.exception.NoUserExistException;
import com.flab.funding.domain.user.exception.WrongPasswordException;
import com.flab.funding.domain.user.infrastructure.SessionAuthentication;
import com.flab.funding.domain.user.repository.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.jdbc.Sql;

@MybatisTest
//@SpringBootTest
//@Sql({"classpath:/schema.sql", "classpath:/data.sql"})
public class SessionLoginServiceTest {

    @Autowired
    UserMapper userMapper;

    SessionAuthentication authentication = new SessionAuthentication(new MockHttpSession());

    UserLoginService loginService;

    @BeforeEach
    void init() {
        loginService = new UserLoginService(authentication, userMapper);
    }

    @DisplayName("로그인 성공")
    @Test
    void loginSuccessTest() {
        Assertions.assertTrue(loginService.login("testId", "12345678"));
    }

    @DisplayName("로그인 실패")
    @Test
    void loginFailTest() {
        Assertions.assertThrows(WrongPasswordException.class, () -> loginService.login("testId", "111"));
        Assertions.assertThrows(NoUserExistException.class, () -> loginService.login("testId!!", "111"));

    }
}
