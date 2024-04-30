package com.greengrow.backend.exception;

/**
 * Exception thrown to indicate that a validation error has occurred.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
public class ValidationException extends RuntimeException {

    /**
     * Constructs a new ValidationException with no detail message.
     */
    public ValidationException() {
        super();
    }

    /**
     * Constructs a new ValidationException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method).
     */
    public ValidationException(String message) {
        super(message);
    }
}
