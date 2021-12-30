package com.flab.funding.domain.user.exception;

import static com.flab.funding.common.constant.ResponseCode.NO_USER_EXIST;

public class NoUserExistException extends FailedLoginException{
    public NoUserExistException() {
        super(NO_USER_EXIST);
    }
}
