package ru.medicaltickets.MyServiceJava.user.client.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.global.exceptions.IdentifierMismatchException;
import ru.medicaltickets.MyServiceJava.user.client.Client;
import ru.medicaltickets.MyServiceJava.user.client.ClientService;

public class UpdateClientHandler {
    private final ClientService clientService;

    public UpdateClientHandler(ClientService clientService) {
        this.clientService = clientService;
    }

    public ResponseEntity<?> handle(String clientID, Client client) {
        Long parsedClientID = Long.parseLong(clientID);
        if (!client.getID().equals(parsedClientID)) throw new IdentifierMismatchException("Attempt to throw a forbidden ID");
        return ResponseEntity.status(HttpStatus.OK).body(clientService.update(client));
    }
}
