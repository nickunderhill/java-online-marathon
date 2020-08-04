package com.softserve.edu.exception;

public class AbsentIdException extends RuntimeException{
    public AbsentIdException(Long id) {
        super("No entity with "+id+" exist.");
    }
}
