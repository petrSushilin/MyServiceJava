package ru.medicaltickets.MyServiceJava.user.client.handlers;


import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.client.Client;
import ru.medicaltickets.MyServiceJava.user.client.ClientService;

public class PostClientHandler {
    private final ClientService clientService;

    public PostClientHandler(ClientService userService) {
        this.clientService = userService;
    }

    public ResponseEntity<?> handle(Client client) {
        return clientService.postUser();
    }
}
