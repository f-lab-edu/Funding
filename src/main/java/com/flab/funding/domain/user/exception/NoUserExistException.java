package com.flab.funding.domain.user.exception;

public class NoUserExistException extends FailedLoginException{
    public NoUserExistException() {
        super("회원정보가 존재하지 않습니다.");
    }
}
