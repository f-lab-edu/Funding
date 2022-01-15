package com.flab.funding.domain.user.repository;

import com.flab.funding.domain.user.model.UserRole;
import com.flab.funding.domain.user.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@DataJpaTest
@Sql({"classpath:/sql/h2-data.sql"})
public class LoginJpaTest {
    
    @Autowired
    private UserJpaRepository userJpaRepo;

    @DisplayName("로그인 아이디로 User조회 성공")
    @Test
    void loginSuccessTest() {

        //given
        Optional<User> expectUser = Optional.of(testUserData());

        //when
        Optional<User> actualUser = userJpaRepo.findByUserId("testId");

        //then
        Assertions.assertEquals(expectUser.map(User::getId), actualUser.map(User::getId));
        Assertions.assertEquals(expectUser.map(User::getUserId), actualUser.map(User::getUserId));
        Assertions.assertEquals(expectUser.map(User::getUserName), actualUser.map(User::getUserName));
        Assertions.assertEquals(expectUser.map(User::getUserRole), actualUser.map(User::getUserRole));
    }

    private User testUserData() {
        return User.builder()
                .id(1L)
                .userName("홍길동")
                .password("12345678")
                .userId("testId")
                .email("test@google.com")
                .phone("01012341234")
                .si("서울시")
                .gu("강남구")
                .dong("역삼동")
                .address("1번지")
                .userRole(UserRole.ORDERER)
                .build();
    }
}
