package com.flab.funding.domain.user.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDto {

    @NonNull
    private String id;
    @NonNull
    private String password;
    @NonNull
    private int type;
    private String name;
    private String phone;
    private Date createdAt;
}
