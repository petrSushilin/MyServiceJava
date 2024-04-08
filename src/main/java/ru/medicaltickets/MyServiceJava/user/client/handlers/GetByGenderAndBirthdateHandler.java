package ru.medicaltickets.MyServiceJava.user.client.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.client.ClientService;
import ru.medicaltickets.MyServiceJava.user.enums.Gender;

import java.time.LocalDate;

public class GetByGenderAndBirthdateHandler {
    private final ClientService clientService;

    public GetByGenderAndBirthdateHandler(ClientService clientService) {
        this.clientService = clientService;
    }

    public ResponseEntity<?> handle(String gender, String birthdate) {
        Gender parsedGender = Gender.valueOf(gender);
        LocalDate parsedBirthdate = LocalDate.parse(birthdate);
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getByGenderAndBirthdate(parsedGender, parsedBirthdate));
    }
}
