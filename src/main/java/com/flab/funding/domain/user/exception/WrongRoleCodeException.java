package com.flab.funding.domain.user.exception;


import com.flab.funding.common.model.BasicException;

import static com.flab.funding.common.constant.ResponseCode.INTERNAL_SERVER_ERROR;

public class WrongRoleCodeException extends BasicException {
    public WrongRoleCodeException() {
        super(INTERNAL_SERVER_ERROR);
    }
}
