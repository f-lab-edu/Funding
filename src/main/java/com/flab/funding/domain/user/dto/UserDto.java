package com.flab.funding.domain.user.dto;

import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
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

    public UserDto(String id, String password, int type, String name, String phone) {
        this.id = id;
        this.password = password;
        this.type = type;
        this.name = name;
        this.phone = phone;
    }
}
