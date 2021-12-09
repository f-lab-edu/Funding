package com.flab.funding.domain.user.infrastructure;

import com.flab.funding.domain.user.entity.UserRole;
import com.flab.funding.global.constant.SessionConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
@RequiredArgsConstructor
public class SessionAuthentication implements Authentication {

    private final HttpSession session;

    @Override
    public void saveLoginAuthInfo(String loginId, String loginName, UserRole userRole) {

        session.setAttribute(SessionConstant.SESSION_LOGIN_ID, loginId);
        session.setAttribute(SessionConstant.SESSION_NAME, loginName);
        session.setAttribute(SessionConstant.SESSION_ROLE, userRole);

        System.out.println("Login Success");
    }

    @Override
    public boolean checkLoginAuthInfo() {
        return false;
    }

    @Override
    public boolean invalidateLoginAuthInfo() {
        return false;
    }

    @Override
    public boolean getLoginAuthInfo() {
        return false;
    }
}
