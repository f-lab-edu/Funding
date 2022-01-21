package com.flab.funding.common.model;

import static com.flab.funding.common.constant.ResponseCode.NO_AUTH;

public class NoAuthException extends BasicException{
    public NoAuthException() {
        super(NO_AUTH);
    }
}
