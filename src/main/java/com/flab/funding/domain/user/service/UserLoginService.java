package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.model.LoginedUser;
import com.flab.funding.domain.user.model.User;
import com.flab.funding.domain.user.infrastructure.Authentication;
import com.flab.funding.domain.user.exception.NoUserExistException;
import com.flab.funding.domain.user.exception.WrongPasswordException;
import com.flab.funding.domain.user.repository.UserJpaRepository;
import com.flab.funding.domain.user.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserLoginService implements LoginService {

    private final Authentication authentication;
//    private final UserMapper userMapper;
    private final UserJpaRepository userRepo;

    @Override
    public void login(String loginId, String loginPw) {

//        Optional<User> loginUser = userMapper.selectByUserId(loginId);
        User loginUser = userRepo.findByUserId(loginId).orElseThrow(NoUserExistException::new);
        if(! checkLoginPw(loginPw, loginUser.getPassword())) {
            throw new WrongPasswordException();
        }
        authentication.saveLoginAuthInfo(loginUser.getUserId(), loginUser.getUserName(), loginUser.getUserRole());
    }

    @Override
    public void logout() {
        authentication.invalidateLoginAuthInfo();
    }

    @Override
    public Optional<LoginedUser> getLoginInfo() {
        return authentication.getLoginAuthInfo();
    }

    private boolean checkLoginPw(String loginPw, String usersPw) {

        //TODO: Encrypt password
        String encryptedPw = loginPw;

        return encryptedPw.equals(usersPw);
    }


}
