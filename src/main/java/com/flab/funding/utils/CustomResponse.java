package com.flab.funding.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class CustomResponse {
    public static ResponseEntity<Object> generateExceptionResponse(String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", status.value());
        map.put("message", message);
        return new ResponseEntity<Object>(map, status);
    }
}
