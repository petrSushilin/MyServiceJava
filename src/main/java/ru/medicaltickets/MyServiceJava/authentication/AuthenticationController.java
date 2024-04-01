package ru.medicaltickets.MyServiceJava.authentication;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("auth")
public class AuthenticationController {
    private AuthenticationHandler authenticationHandler;

    public AuthenticationController(AuthenticationHandler authenticationHandler) {
        this.authenticationHandler = authenticationHandler;
    }
}
