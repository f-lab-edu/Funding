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
    public boolean login(String loginId, String loginPw) {

//        Optional<User> loginUser = userMapper.selectByUserId(loginId);
        Optional<User> loginUser = userRepo.findByUserId(loginId);
        loginUser.map( x -> checkLoginPw(loginPw, x))
                .orElseThrow(NoUserExistException::new);

        return true;
    }

    @Override
    public void logout() {
        authentication.invalidateLoginAuthInfo();
    }

    @Override
    public Optional<LoginedUser> getLoginInfo() {
        return authentication.getLoginAuthInfo();
    }

    private Optional<User> checkLoginPw(String loginPw, User loginUser) {

        //TODO: Encrypt password
        String encryptedPw = loginPw;

        if (!encryptedPw.equals(loginUser.getPassword())) {
            throw new WrongPasswordException();
        }
        return Optional.of(loginUser);
    }


}
