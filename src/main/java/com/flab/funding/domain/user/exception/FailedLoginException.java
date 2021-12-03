package com.flab.funding.domain.user.exception;

public class FailedLoginException extends RuntimeException{
    public FailedLoginException(String s) {
        super(s);
    }
}
