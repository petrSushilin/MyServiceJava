package ru.medicaltickets.MyServiceJava.global.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.medicaltickets.MyServiceJava.global.exceptions.RequestNotFoundException;
import ru.medicaltickets.MyServiceJava.global.GlobalAppErrorEntity;

import java.time.format.DateTimeParseException;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<GlobalAppErrorEntity> handleNumberFormatException(NumberFormatException ex) {
        return new ResponseEntity<>(new GlobalAppErrorEntity(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<GlobalAppErrorEntity> handleMethodArgumentTypeMismatchException
                                                                (MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>(new GlobalAppErrorEntity(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<GlobalAppErrorEntity> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new GlobalAppErrorEntity(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DateTimeParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<GlobalAppErrorEntity> handleDateTimeParseException(DateTimeParseException ex) {
        return new ResponseEntity<>(new GlobalAppErrorEntity(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<GlobalAppErrorEntity> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(new GlobalAppErrorEntity(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RequestNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<GlobalAppErrorEntity> handleResourceNotFoundException(RequestNotFoundException e) {
        return new ResponseEntity<>(new GlobalAppErrorEntity(
                HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
