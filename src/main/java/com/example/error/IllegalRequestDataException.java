package com.example.error;

public class IllegalRequestDataException extends RuntimeException {

    public IllegalRequestDataException(String msg) {
        super(msg);
    }
}