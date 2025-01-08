package com.example.dtodemo.exception;

public class RegistrationException extends RuntimeException {
    public RegistrationException(String emailIsAlreadyRegistered) {
        super(emailIsAlreadyRegistered);
    }
}
