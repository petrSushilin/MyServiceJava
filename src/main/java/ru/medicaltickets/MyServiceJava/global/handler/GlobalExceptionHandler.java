package ru.medicaltickets.MyServiceJava.global.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.medicaltickets.MyServiceJava.global.exceptions.RequestNotFoundException;
import ru.medicaltickets.MyServiceJava.global.GlobalAppError;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<GlobalAppError> catchResourceNotFoundException(RequestNotFoundException e) {
        return new ResponseEntity<>(new GlobalAppError(
                HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
