package ru.medicaltickets.MyServiceJava.global.exceptions;

public class InvalidDateSearchException extends RuntimeException {
    public InvalidDateSearchException(String message) {
        super(message);
    }
}
