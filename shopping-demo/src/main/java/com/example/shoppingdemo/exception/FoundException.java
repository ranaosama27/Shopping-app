package com.example.shoppingdemo.exception;

public class FoundException extends RuntimeException{

    public FoundException() {

    }

    public FoundException(String message) {
        super(message);
    }

    protected FoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
