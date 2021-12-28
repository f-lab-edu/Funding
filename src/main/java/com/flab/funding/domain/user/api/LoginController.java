package com.flab.funding.domain.user.api;

import com.flab.funding.domain.user.entity.LoginRequest;
import com.flab.funding.domain.user.entity.LoginedUser;
import com.flab.funding.domain.user.infrastructure.Authentication;
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

    // TODO: return type 변경
    @PostMapping("/login")
    public ResponseEntity<LoginedUser> login(@RequestBody LoginRequest loginReq) {

        loginService.login(loginReq.getLoginId(), loginReq.getLoginPw());

        log.info("login controller finished");

        return ResponseEntity.of(loginService.getLoginInfo());
    }

}
