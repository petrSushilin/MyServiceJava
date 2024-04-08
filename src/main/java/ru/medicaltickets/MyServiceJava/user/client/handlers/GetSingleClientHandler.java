package ru.medicaltickets.MyServiceJava.user.client.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.client.ClientService;

public class GetSingleClientHandler {
    private final ClientService clientService;

    public GetSingleClientHandler(ClientService clientService) {
        this.clientService = clientService;
    }

    public ResponseEntity<?> handle(String clientID) {
        Long parsedClientID = Long.parseLong(clientID);
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getSingle(parsedClientID));
    }
}
