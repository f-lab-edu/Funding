package com.flab.funding.domain.user.repository;

import com.flab.funding.domain.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

//    @Select("SELECT * FROM USERS WHERE USER_ID = #{loginId}")
//    User selectByUserId(@Param("loginId") String loginId);

    Optional<User> selectByUserId(String loginId);

}
