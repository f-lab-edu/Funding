package com.flab.funding.common.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BasicResponse<T> {
    private boolean success;
    private T response;
    private ErrorEntity error;
}
