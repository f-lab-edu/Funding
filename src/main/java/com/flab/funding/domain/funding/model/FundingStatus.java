package com.flab.funding.domain.funding.model;

import com.flab.funding.domain.funding.exception.WrongFundingStatusException;
import lombok.Getter;

import java.util.Arrays;

public enum FundingStatus {
    ING(1),
    CANCEL(2),
    SUCCESS(3),
    FAIL(4);

    @Getter
    private final int statusCode;

    FundingStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public static FundingStatus getStatusName(int statusCode) {

        return Arrays.stream(FundingStatus.values()).filter(x-> x.getStatusCode() == statusCode)
                .findFirst().orElseThrow(WrongFundingStatusException::new);
    }
}
