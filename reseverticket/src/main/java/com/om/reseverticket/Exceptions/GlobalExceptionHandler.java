package com.om.reseverticket.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TrainNotFoundException.class)
    public ResponseEntity<String> handleTrainNotFound(TrainNotFoundException td){
        return new ResponseEntity<>(td.getMessage(), HttpStatus.NOT_FOUND);

    }
}
