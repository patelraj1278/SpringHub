package com.example.springhub.error;

public class NoPublisherFoundException extends Exception{

    public NoPublisherFoundException(String message){
        super(message);
    }
}
