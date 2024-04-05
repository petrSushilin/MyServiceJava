package ru.medicaltickets.MyServiceJava.global.exceptions;

public class IdentifierMismatchException extends RuntimeException {
    public IdentifierMismatchException(String message) {
        super(message);
    }
    // return code 400
}
