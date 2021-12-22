package com.flab.funding.domain.user.api;


import com.flab.funding.domain.user.exception.DuplicatedIdExistException;
import com.flab.funding.domain.user.exception.UserDoesNotExistException;
import com.flab.funding.utils.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class UserExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicatedIdExistException.class)
    public ExceptionResponse handleDuplicatedIdExistException(DuplicatedIdExistException e) {
        return new ExceptionResponse(e.getMessage(), 400);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserDoesNotExistException.class)
    public ExceptionResponse handleUserDoesNotExistException(UserDoesNotExistException e) {
        return new ExceptionResponse(e.getMessage(), 404);
    }
}
