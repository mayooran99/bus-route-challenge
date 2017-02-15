package com.busroute.challenge.errors;

/**
 * Exception to be thrown for file reading related issues
 */
public class FileAccessException extends Exception {
    /**
     * Default constructor.
     */
    public FileAccessException() {
        super();
    }

    /**
     * Constructor to instantiate with the message.
     *
     * @param message Exception message
     */
    public FileAccessException(String message) {
        super(message);
    }

    /**
     * Constructor to instantiate with the message and the cause.
     *
     * @param message Exception message
     * @param cause   Cause for the exception
     */
    public FileAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
