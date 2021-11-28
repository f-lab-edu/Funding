package com.flab.funding.global.exception.user;

public class NoUserExistException extends FailedLoginException{
    public NoUserExistException() {
        super("회원정보가 존재하지 않습니다.");
    }
}
