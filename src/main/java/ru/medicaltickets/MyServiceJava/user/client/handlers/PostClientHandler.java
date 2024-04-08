package ru.medicaltickets.MyServiceJava.user.client.handlers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.global.exceptions.IdentifierMismatchException;
import ru.medicaltickets.MyServiceJava.user.AbstractUser;
import ru.medicaltickets.MyServiceJava.user.client.Client;
import ru.medicaltickets.MyServiceJava.user.client.ClientService;

public class PostClientHandler {
    private final ClientService clientService;

    public PostClientHandler(ClientService userService) {
        this.clientService = userService;
    }

    public ResponseEntity<?> handle(Client client) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.post(client));
    }
}
