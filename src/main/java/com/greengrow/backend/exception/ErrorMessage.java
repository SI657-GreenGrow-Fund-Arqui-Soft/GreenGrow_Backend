package com.greengrow.backend.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Represents an error message with details such as status code, message, description, and timestamp.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    /**
     * The HTTP status code associated with the error.
     */
    private int statusCode;

    /**
     * A brief message describing the error.
     */
    private String message;

    /**
     * Additional details or context about the error.
     */
    private String description;

    /**
     * The timestamp when the error occurred.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
}