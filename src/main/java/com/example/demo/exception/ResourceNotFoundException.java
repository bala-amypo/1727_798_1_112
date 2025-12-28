package com.example.demo.exception;

/**
 * Thrown when a requested resource is not found
 * (example: user, holder, credential, verification request).
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
