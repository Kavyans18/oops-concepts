package com.pws.JavaOOPSConcepts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<String> handleIdNotFoundExceptionHandler(IdNotFoundException exception) {
        exception.getMessage();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PhoneNumberNotFoundException.class)
    public ResponseEntity<String> handlePhoneNotFoundException(PhoneNumberNotFoundException exception) {
        exception.getMessage();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<String> handleEmailNotFoundException(EmailNotFoundException exception) {
        exception.getMessage();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoDataAvailableException.class)
    public ResponseEntity<String> handleNoDataAvailableException(NoDataAvailableException exception){
        exception.getMessage();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
