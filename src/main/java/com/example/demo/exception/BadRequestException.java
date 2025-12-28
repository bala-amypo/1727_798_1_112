package com.example.demo.exception;

/**
 * Thrown when a client sends an invalid request
 * (example: duplicate email during registration).
 */
public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }
}
