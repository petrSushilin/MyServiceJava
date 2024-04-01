package ru.medicaltickets.MyServiceJava.authentication;

import org.springframework.stereotype.Service;

public class AuthenticationHandler {
    private AuthenticationDAO authenticationDAO;

    public AuthenticationHandler(AuthenticationDAO authenticationDAO) {
        this.authenticationDAO = authenticationDAO;
    }
}
