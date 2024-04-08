package ru.medicaltickets.MyServiceJava.user.client.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.client.ClientService;

public class GetByFullNameHandler {
    private final ClientService clientService;

    public GetByFullNameHandler(ClientService clientService) {
        this.clientService = clientService;
    }

    public ResponseEntity<?> handle (String firstName, String lastName) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getByFullName(firstName + " " + lastName));
    }
}
