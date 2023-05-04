package com.example.springinaction.tacoapp.exceptions;

public class NoSuchUserExistsException extends RuntimeException{
    public NoSuchUserExistsException(String message) {
        super(message);
    }
}
