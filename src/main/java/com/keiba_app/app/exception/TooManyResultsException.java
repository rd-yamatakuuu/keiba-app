package com.keiba_app.app.exception;

public class TooManyResultsException extends RuntimeException{
    public TooManyResultsException(String message){
        super(message);
    }
}
