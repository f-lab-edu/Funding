package com.flab.funding.common.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.flab.funding.common.constant.ResponseCode;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ErrorEntity {
    private int status;
    private String errMessage;

    public ErrorEntity(ResponseCode resCode) {
        this(resCode.getResCd(), resCode.getResMsg());
    }
}