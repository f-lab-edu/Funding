package com.flab.funding.common.model;

import com.flab.funding.common.constant.ResponseCode;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BasicException extends RuntimeException{
    private ResponseCode responseCode;
}
