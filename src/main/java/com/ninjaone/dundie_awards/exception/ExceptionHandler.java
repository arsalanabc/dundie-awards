package com.ninjaone.dundie_awards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> notFoundException(Exception e, WebRequest webRequest){
        return new ResponseEntity<>(new Error(new Date(), e.getMessage(), webRequest.getDescription(false)), HttpStatus.NOT_FOUND);
    }
}
