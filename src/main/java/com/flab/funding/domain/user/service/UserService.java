package com.flab.funding.domain.user.service;

import com.flab.funding.domain.user.dao.UserMapper;
import com.flab.funding.domain.user.dto.UserDto;
import com.flab.funding.domain.user.exception.DuplicatedIdExistException;
import com.flab.funding.domain.user.exception.UserDoesNotExistException;
import com.flab.funding.utils.PasswordEncryptUtil;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    public void join(UserDto userDto) {
        validateDuplicateId(userDto);
        String encryptedPassword = PasswordEncryptUtil.encryptSHA256(userDto.getPassword());
        UserDto user = new UserDto(userDto.getId(), encryptedPassword, userDto.getType(), userDto.getName(), userDto.getPhone());
        userMapper.insert(user);
    }

    private void validateDuplicateId(UserDto userDto) {
        Optional<UserDto> user = Optional.ofNullable(userMapper.selectById(userDto.getId()));
        if (user.isPresent()) {
            throw new DuplicatedIdExistException("이미 존재하는 id입니다.");
        }
    }

    public UserDto findUserById(String id) {
        Optional<UserDto> user = Optional.ofNullable(userMapper.selectById(id));
        return user.orElseThrow(() -> new UserDoesNotExistException("해당 id를 가진 유저가 존재하지 않습니다."));

    }

}
