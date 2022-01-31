package com.flab.funding.common.interceptor;

import com.flab.funding.common.annotation.AuthRequired;
import com.flab.funding.common.model.NoAuthException;
import com.flab.funding.domain.user.infrastructure.Authentication;
import com.flab.funding.domain.user.model.dto.LoginRes;
import com.flab.funding.domain.user.model.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final Authentication authentication;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        AuthRequired authRequired = getAuthRequired(handler);

        UserRole[] acceptRoleList = new UserRole[] {};
        if(authRequired != null) {
            acceptRoleList = authRequired.acceptRole();
        }
        LoginRes loginedUser = authentication.getLoginAuthInfo().orElseThrow(NoAuthException::new);

        boolean isMatched = Arrays.asList(acceptRoleList).contains(loginedUser.getUserRole());
        return isMatched;
    }

    private AuthRequired getAuthRequired(Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        return handlerMethod.getMethod().getAnnotation(AuthRequired.class);
    }

}
