package com.flab.funding.domain.user.entity;

import com.flab.funding.domain.user.exception.WrongRoleCodeException;
import lombok.Getter;

import java.util.Arrays;

public enum UserRole {
    SELLER(1),
    ORDERER(2);

    @Getter
    private final int roleCode;

    UserRole(int roleCode) {
        this.roleCode = roleCode;
    }

    public static UserRole getRoleName(int roleCode) {

        Arrays.stream(UserRole.values()).filter(x-> x.getRoleCode() == roleCode).findFirst().orElseThrow(() -> new WrongRoleCodeException());
        for (UserRole userRole : UserRole.values()) {
            if (userRole.getRoleCode() == roleCode)
                return userRole;
        }

        return null;
    }
}
