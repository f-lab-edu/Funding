package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.exception.NoUserExistException;
import com.flab.funding.domain.user.infrastructure.Authentication;
import com.flab.funding.domain.user.model.User;
import com.flab.funding.domain.user.repository.UserJpaRepository;
import com.flab.funding.domain.user.repository.UserMapper;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserLoginServiceTest {

  @Mock
  private Authentication authentication;
  @Mock
//  private UserMapper userMapper;
  private UserJpaRepository userJpaRepo;

  @Test
  @DisplayName("존재하지 않는 ID로 로그인을 시도하려고 할 때 예외가 발생#loginUservice.login")
  void expectThrowsException_whenLoginByNotExistUserId() {
    var NO_EXIST_USER_ID = "noid";
    var NO_EXIST_USER_PASSWORD = "password";

//    when(userMapper.selectByUserId(NO_EXIST_USER_ID)).thenReturn(Optional.empty());
    when(userJpaRepo.findByUserId(NO_EXIST_USER_ID)).thenReturn(Optional.empty());

//    var loginUservice = new UserLoginService(authentication, userMapper);
    var loginUserService = new UserLoginService(authentication, userJpaRepo);

    assertThrows(NoUserExistException.class,
        () -> loginUserService.login(NO_EXIST_USER_ID, NO_EXIST_USER_PASSWORD));

  }

  @Test
  @DisplayName("존재하는 ID로 로그긴을 시도하려고 할때, 정상처리됨#loginUservice.login")
  void testLoginUserIdAndPassword() {
    var TEST_USER_ID = "deveun";
    var TEST_USER_PASSWORD = "#123pas!!";
//    when(userMapper.selectByUserId(TEST_USER_ID)).thenReturn(Optional.of(testUserData()));
    when(userJpaRepo.findByUserId(TEST_USER_ID)).thenReturn(Optional.of(testUserData()));

//    var loginUservice = new UserLoginService(authentication, userMapper);
    var loginUserService = new UserLoginService(authentication, userJpaRepo);

    assertDoesNotThrow(()->loginUserService.login(TEST_USER_ID, TEST_USER_PASSWORD));

  }

  private User testUserData() {
    return User.builder()
        .id(1L)
        .userName("deveun")
        .password("#123pas!!")
        .userId("deveun")
        .build();
  }
}