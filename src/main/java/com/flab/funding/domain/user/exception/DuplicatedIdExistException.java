package com.flab.funding.domain.user.exception;

public class DuplicatedIdExistException extends RuntimeException{

    public DuplicatedIdExistException(String message){
        super(message);
    }
}
