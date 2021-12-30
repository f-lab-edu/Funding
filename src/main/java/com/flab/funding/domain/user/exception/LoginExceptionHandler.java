package com.flab.funding.domain.user.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class LoginExceptionHandler {

    @ExceptionHandler(FailedLoginException.class)
//    @ExceptionHandler(value = {NoUserExistException.class, WrongPasswordException.class})
    public Error handleLoginException(FailedLoginException e) {

        log.error("Exception({}) - {}", e.getClass().getSimpleName(), e.getMessage());
        return new Error(e);
    }

}
