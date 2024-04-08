package ru.medicaltickets.MyServiceJava.user.client.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.client.ClientService;
import ru.medicaltickets.MyServiceJava.user.enums.Gender;

public class GetByLastNameAndGenderHandler {
    private final ClientService clientService;

    public GetByLastNameAndGenderHandler(ClientService clientService) {
        this.clientService = clientService;
    }

    public ResponseEntity<?> handle(String lastName, String gender) {
        Gender parsedGender = Gender.valueOf(gender);
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getByLastNameAndGender(lastName, parsedGender));
    }
}
