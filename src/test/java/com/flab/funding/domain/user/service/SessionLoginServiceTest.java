package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.exception.NoUserExistException;
import com.flab.funding.domain.user.exception.WrongPasswordException;
import com.flab.funding.domain.user.infrastructure.SessionAuthentication;
import com.flab.funding.domain.user.repository.UserJpaRepository;
import com.flab.funding.domain.user.repository.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

//@MybatisTest
//@SpringBootTest
//@Sql({"classpath:/h2-schema.sql", "classpath:/h2-data.sql"})
@DataJpaTest
public class SessionLoginServiceTest {

    @Autowired
//    UserMapper userMapper;
    UserJpaRepository userJpaRepo;

    SessionAuthentication authentication = new SessionAuthentication(new MockHttpSession());

    UserLoginService loginService;

    @BeforeEach
    void init() {
//        loginService = new UserLoginService(authentication, userMapper);
        loginService = new UserLoginService(authentication, userJpaRepo);

    }

    @DisplayName("로그인 성공")
    @Test
    void loginSuccessTest() {
        assertDoesNotThrow(()->loginService.login("testId", "12345678"));
    }

    @DisplayName("로그인 실패")
    @Test
    void loginFailTest() {
        Assertions.assertThrows(WrongPasswordException.class, () -> loginService.login("testId", "111"));
        Assertions.assertThrows(NoUserExistException.class, () -> loginService.login("testId!!", "111"));

    }

    @DisplayName("로그아웃 성공")
    @Test
    void logoutSuccessTest() {
        loginService.logout();
        Assertions.assertEquals(loginService.getLoginInfo(), Optional.empty());
    }
}
