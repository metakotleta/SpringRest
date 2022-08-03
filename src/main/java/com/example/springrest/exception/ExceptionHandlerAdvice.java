package com.example.springrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler
    public ResponseEntity<String> unauthorizedUser(UnauthorizedUser unauthorizedUser) {
        return new ResponseEntity<>(unauthorizedUser.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<String> invalidCredentials(BindException bindException) {
        return new ResponseEntity<>(bindException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
