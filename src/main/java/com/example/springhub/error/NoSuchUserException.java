package com.example.springhub.error;

public class NoSuchUserException extends Exception{

    public NoSuchUserException(String message){
        super(message);
    }
}
