package com.flab.funding.domain.user.exception;

public class WrongPasswordException extends FailedLoginException{
    public WrongPasswordException() {
        super("비밀번호가 틀렸습니다.");
    }
}
