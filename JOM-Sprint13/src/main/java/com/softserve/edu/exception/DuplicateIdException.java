package com.softserve.edu.exception;

public class DuplicateIdException extends RuntimeException {
    public DuplicateIdException(Long id) {
        super("Entity with " + id + " already exists.");
    }
}
