package com.pws.JavaOOPSConcepts.exception;

import net.bytebuddy.implementation.bind.annotation.Super;

public class NoDataAvailableException extends RuntimeException{
    String message = "NO DATA AVAILABLE IN THE DATABASE";

    public NoDataAvailableException(String message) {
        super();
        this.message =message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
