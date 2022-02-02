package com.flab.funding.domain.user.infrastructure;

import com.flab.funding.domain.user.model.dto.LoginRes;
import com.flab.funding.domain.user.model.UserRole;
import com.flab.funding.common.constant.SessionConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class SessionAuthentication implements Authentication {

    private final HttpSession session;

    @Override
    public void saveLoginAuthInfo(String loginId, String loginName, UserRole userRole) {

        session.setAttribute(SessionConstant.SESSION_LOGIN_ID, loginId);
        session.setAttribute(SessionConstant.SESSION_NAME, loginName);
        session.setAttribute(SessionConstant.SESSION_ROLE, userRole);

        log.info("Login Success");
    }

    @Override
    public boolean checkLoginAuthInfo() {

        try {
            return session.getAttribute(SessionConstant.SESSION_LOGIN_ID) != null
                    && session.getAttribute(SessionConstant.SESSION_NAME) != null
                    && session.getAttribute(SessionConstant.SESSION_ROLE) != null;
        } catch(IllegalStateException e) {
            return false;
        }
    }

    @Override
    public void invalidateLoginAuthInfo() {
        session.invalidate();
    }

    @Override
    public Optional<LoginRes> getLoginAuthInfo() {
        if(checkLoginAuthInfo()) {
            return Optional.of(new LoginRes((String) session.getAttribute(SessionConstant.SESSION_LOGIN_ID)
                    , (String) session.getAttribute(SessionConstant.SESSION_NAME)
                    , (UserRole) session.getAttribute(SessionConstant.SESSION_ROLE)));
        }

        return Optional.empty();
    }
}
