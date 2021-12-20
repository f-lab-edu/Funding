package com.flab.funding.domain.user.exception;


public class WrongRoleCodeException extends RuntimeException{
    public WrongRoleCodeException() {
        super("사용자 타입코드가 잘못되었습니다.");
    }
}
