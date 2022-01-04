package com.flab.funding.common.model;

import static com.flab.funding.common.constant.ResponseCode.WRONG_CODE;

public class CodeException extends BasicException{
    public CodeException() {
        super(WRONG_CODE);
    }

}
