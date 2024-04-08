package ru.medicaltickets.MyServiceJava.user.client.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.client.ClientService;

public class GetPensionersHandler {
    private final ClientService clientService;

    public GetPensionersHandler(ClientService clientService) {
        this.clientService = clientService;
    }

    public ResponseEntity<?> handle() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getPensioners());
    }
}
