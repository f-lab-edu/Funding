package com.flab.funding.domain.user.infrastructure;

import com.flab.funding.domain.user.model.dto.LoginRes;
import com.flab.funding.domain.user.model.UserRole;

import java.util.Optional;

public interface Authentication {
    void saveLoginAuthInfo(String loginId, String loginName, UserRole userRole);
    boolean checkLoginAuthInfo();
    void invalidateLoginAuthInfo();
    Optional<LoginRes> getLoginAuthInfo();

}
