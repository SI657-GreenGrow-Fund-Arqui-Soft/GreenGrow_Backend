package com.greengrow.backend.apigateway.exceptions;

public class ArticlesException extends RuntimeException {

    private final String message;
    private final String errorCode;
    private final int status;

    public ArticlesException(String message, String errorCode, int status) {
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public int getStatus() {
        return status;
    }
}
