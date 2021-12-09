package com.flab.funding.domain.user.exception;

public class PasswordEncryptException extends RuntimeException {
    public PasswordEncryptException(String message) {
        super(message);
    }
}
