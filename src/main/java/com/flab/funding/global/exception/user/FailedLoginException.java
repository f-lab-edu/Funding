package com.flab.funding.global.exception.user;

public class FailedLoginException extends RuntimeException{
    public FailedLoginException(String s) {
        super(s);
    }
}
