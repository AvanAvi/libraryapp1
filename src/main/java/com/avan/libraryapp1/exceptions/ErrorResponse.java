package com.avan.libraryapp1.exceptions;

public class ErrorResponse {
    private String message;
    private int status;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    // Standard getters and setters
}
