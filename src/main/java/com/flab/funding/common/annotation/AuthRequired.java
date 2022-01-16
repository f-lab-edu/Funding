package com.flab.funding.common.annotation;

import com.flab.funding.domain.user.model.UserRole;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthRequired {
    UserRole[] acceptRole() default {UserRole.SELLER, UserRole.ORDERER};
}
