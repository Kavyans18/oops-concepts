package com.pws.JavaOOPSConcepts.exception;

public class PhoneNumberNotFoundException extends RuntimeException {
    String message = "No data found under this email";

    public PhoneNumberNotFoundException(){
        super();
    }

    public PhoneNumberNotFoundException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

