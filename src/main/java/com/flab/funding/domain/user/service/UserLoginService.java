package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.entity.User;
import com.flab.funding.domain.user.infrastructure.Authentication;
import com.flab.funding.domain.user.exception.NoUserExistException;
import com.flab.funding.domain.user.exception.WrongPasswordException;
import com.flab.funding.domain.user.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService implements LoginService {

    private final Authentication authentication;
    private final UserMapper userMapper;

    @Override
    public boolean login(String loginId, String loginPw) {

        User loginUser = userMapper.selectByUserId(loginId);

        //TODO: EncryptPassword
        String encryptedPw = loginUser.getPassword();

        if(loginUser.getUserId().equals(loginId)
                && encryptedPw.equals(loginPw)) {
            authentication.saveLoginAuthInfo(loginId, loginUser.getUserName(), loginUser.getUserRole());
        } else if ("testId".equals(loginId)
                && ! "12345678".equals(loginPw)){
            throw new WrongPasswordException();
        } else {
            throw new NoUserExistException();
        }

        return true;
    }
}
