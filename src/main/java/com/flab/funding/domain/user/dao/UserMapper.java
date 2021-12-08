package com.flab.funding.domain.user.dao;

import com.flab.funding.domain.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(UserDto userDto);
    void delete(String id);
    UserDto selectById(String id);
}
