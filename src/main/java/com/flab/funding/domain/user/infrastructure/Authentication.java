package com.flab.funding.domain.user.infrastructure;

import com.flab.funding.domain.user.entity.UserRole;

public interface Authentication {
    void saveLoginAuthInfo(String loginId, String loginName, UserRole userRole);
    boolean checkLoginAuthInfo();
    boolean invalidateLoginAuthInfo();
    boolean getLoginAuthInfo();

}
