package com.flab.funding.domain.user.api;

import com.flab.funding.domain.user.entity.LoginRequest;
import com.flab.funding.domain.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/")
public class LoginController {

    private final LoginService loginService;

    // TODO: return type 변경
    @PostMapping("/login")
    public Boolean login(LoginRequest loginReq) {
        loginService.login(loginReq.getLoginId(), loginReq.getLoginPw());

        System.out.println("로그인 성공");
        return true;
    }

}
