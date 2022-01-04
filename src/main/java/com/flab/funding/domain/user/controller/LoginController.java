package com.flab.funding.domain.user.controller;

import com.flab.funding.domain.user.model.LoginRequest;
import com.flab.funding.domain.user.model.LoginedUser;
import com.flab.funding.domain.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginedUser> login(@RequestBody LoginRequest loginReq) {

        loginService.login(loginReq.getLoginId(), loginReq.getLoginPw());

        return ResponseEntity.of(loginService.getLoginInfo());
    }

    @PostMapping("/logout")
    public void logout() {
        loginService.logout();
    }

}
