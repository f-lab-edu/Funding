package com.flab.funding.domain.user.controller;

import com.flab.funding.domain.user.model.dto.LoginReq;
import com.flab.funding.domain.user.model.dto.LoginRes;
import com.flab.funding.domain.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public Optional<LoginRes> login(@RequestBody LoginReq loginReq) {

        loginService.login(loginReq.getLoginId(), loginReq.getLoginPw());

        return loginService.getLoginInfo();
    }

    @PostMapping("/logout")
    public void logout() {
        loginService.logout();
    }

}
