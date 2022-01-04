package com.flab.funding.common.model;

import com.flab.funding.common.constant.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class BasicException extends RuntimeException{
    private ResponseCode responseCode;

    public BasicException(ResponseCode responseCode) {
        super(responseCode.getResMsg());
        this.responseCode = responseCode;
    }
}
