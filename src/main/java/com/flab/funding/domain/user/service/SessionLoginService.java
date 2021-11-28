package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.entity.LoginRequest;
import com.flab.funding.domain.user.entity.UserRole;
import com.flab.funding.global.constant.SessionConstant;
import com.flab.funding.global.exception.user.NoUserExistException;
import com.flab.funding.global.exception.user.WrongPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class SessionLoginService implements LoginService {

    private final HttpSession session;

    @Override
    public void login(String loginId, String loginPw) {

        // 테스트 코드 통과를 위한 임시 하드코딩
        if("testId".equals(loginId)
                && "12345678".equals(loginPw)) {
            session.setAttribute(SessionConstant.SESSION_LOGIN_ID, loginId);
            session.setAttribute(SessionConstant.SESSION_NAME, "홍길동");
            session.setAttribute(SessionConstant.SESSION_ROLE, UserRole.SELLER);
        } else if ("testId".equals(loginId)
                && ! "12345678".equals(loginPw)){
            throw new WrongPasswordException();
        } else {
            throw new NoUserExistException();
        }
    }
}
