package com.pws.JavaOOPSConcepts.exception;

public class IdNotFoundException extends RuntimeException {
    private String message = "No data found under this Email ID";

    public IdNotFoundException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}