package com.softserve.edu.exception;

public class IncorrectEntityIdException extends RuntimeException {
    public IncorrectEntityIdException(String errorMessage) {
        super(errorMessage);
    }
}