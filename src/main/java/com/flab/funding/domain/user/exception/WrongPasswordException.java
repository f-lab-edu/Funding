package com.flab.funding.domain.user.exception;

import static com.flab.funding.common.constant.ResponseCode.WRONG_PASSWORD;

public class WrongPasswordException extends FailedLoginException{
    public WrongPasswordException() {
        super(WRONG_PASSWORD);
    }
}
