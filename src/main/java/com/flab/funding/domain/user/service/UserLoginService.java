package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.model.dto.LoginRes;
import com.flab.funding.domain.user.model.User;
import com.flab.funding.domain.user.infrastructure.Authentication;
import com.flab.funding.domain.user.exception.NoUserExistException;
import com.flab.funding.domain.user.exception.WrongPasswordException;
import com.flab.funding.domain.user.repository.UserJpaRepository;
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

        if(loginPw.equals(loginUser.getPassword())) {
            authentication.saveLoginAuthInfo(loginUser.getUserId(), loginUser.getName(), loginUser.getUserRole());
        } else {
            throw new WrongPasswordException();
        }
    }

    @Override
    public void logout() {
        authentication.invalidateLoginAuthInfo();
    }

    @Override
    public Optional<LoginRes> getLoginInfo() {
        return authentication.getLoginAuthInfo();
    }

}
