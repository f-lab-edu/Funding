package com.flab.funding.common.aop;

import com.flab.funding.common.model.ErrorEntity;
import com.flab.funding.domain.user.exception.FailedLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(FailedLoginException.class)
//    @ExceptionHandler(value = {NoUserExistException.class, WrongPasswordException.class})
    public ErrorEntity handleLoginException(FailedLoginException e) {

        log.error("Login Exception({}) - {}", e.getClass().getSimpleName(), e.getMessage());
        return new ErrorEntity(e.getResponseCode());
    }

}
