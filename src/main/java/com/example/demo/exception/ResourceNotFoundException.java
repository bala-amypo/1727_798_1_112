package com.example.demo.exception;

/**
 * Thrown when a requested resource is not found in the system.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor with a custom message.
     *
     * @param message error message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor used by service layer.
     * Example:
     * throw new ResourceNotFoundException("User", "id", 10L);
     *
     * @param resourceName name of the resource (Entity)
     * @param fieldName    field used for lookup
     * @param fieldValue   value of the field
     */
    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
        super(String.format(
                "%s not found with %s : '%s'",
                resourceName,
                fieldName,
                fieldValue
        ));
    }
}
