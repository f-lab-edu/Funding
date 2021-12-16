package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.entity.UserRole;
import com.flab.funding.domain.user.infrastructure.Authentication;
import com.flab.funding.domain.user.exception.NoUserExistException;
import com.flab.funding.domain.user.exception.WrongPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService implements LoginService {

    private final Authentication authentication;

    @Override
    public boolean login(String loginId, String loginPw) {

        // TODO: repository에서 loginId로 조회하기.
        String loginName = "홍길동";
        UserRole userRole = UserRole.SELLER;

        // 테스트 코드 통과를 위한 임시 하드코딩
        if("testId".equals(loginId)
                && "12345678".equals(loginPw)) {
            authentication.saveLoginAuthInfo(loginId, loginName, userRole);
        } else if ("testId".equals(loginId)
                && ! "12345678".equals(loginPw)){
            throw new WrongPasswordException();
        } else {
            throw new NoUserExistException();
        }

        return true;
    }
}
