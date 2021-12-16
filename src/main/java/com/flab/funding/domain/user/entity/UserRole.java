package com.flab.funding.domain.user.entity;

import lombok.Getter;

public enum UserRole {
    SELLER(1),
    ORDERER(2);

    @Getter
    private final int roleCode;

    UserRole(int roleCode) {
        this.roleCode = roleCode;
    }
}
