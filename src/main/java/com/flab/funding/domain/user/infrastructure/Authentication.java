package com.flab.funding.domain.user.infrastructure;

import com.flab.funding.domain.user.model.LoginedUser;
import com.flab.funding.domain.user.model.UserRole;

import java.util.Optional;

public interface Authentication {
    void saveLoginAuthInfo(String loginId, String loginName, UserRole userRole);
    boolean checkLoginAuthInfo();
    void invalidateLoginAuthInfo();
    Optional<LoginedUser> getLoginAuthInfo();

}
