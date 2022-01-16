package com.flab.funding.common.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BasicResponse<T> {
    private boolean success;
    private T response;
    private ErrorEntity error;
}
