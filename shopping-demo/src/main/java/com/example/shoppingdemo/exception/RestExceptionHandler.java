package com.example.shoppingdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NotFoundException ex){
        ErrorResponse error=new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage()
                ,System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception ex){
        ErrorResponse error=new ErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getMessage()
                ,System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(FoundException ex){
        ErrorResponse error=new ErrorResponse(HttpStatus.FOUND.value(),ex.getMessage()
                ,System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.FOUND);
    }


}
