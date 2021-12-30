package com.flab.funding.domain.user.exception;

import com.flab.funding.common.constant.ResponseCode;
import com.flab.funding.common.model.BasicException;

public class FailedLoginException extends BasicException {
    public FailedLoginException(ResponseCode responseCode) {
        super(responseCode);
    }
}
