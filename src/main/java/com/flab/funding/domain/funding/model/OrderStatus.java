package com.flab.funding.domain.funding.model;

import com.flab.funding.domain.funding.exception.WrongFundingStatusException;
import lombok.Getter;

import java.util.Arrays;

public enum OrderStatus {
    ING(1),
    CANCEL(2),
    SUCCESS(3),
    FAIL(4);

    @Getter
    private final int statusCode;

    OrderStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public static OrderStatus getStatusName(int statusCode) {

        return Arrays.stream(OrderStatus.values()).filter(x-> x.getStatusCode() == statusCode)
                .findFirst().orElseThrow(WrongFundingStatusException::new);
    }
}
