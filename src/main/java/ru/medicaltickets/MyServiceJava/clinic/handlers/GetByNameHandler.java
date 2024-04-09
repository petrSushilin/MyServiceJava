package ru.medicaltickets.MyServiceJava.clinic.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.clinic.ClinicService;

public class GetByNameHandler {
    private final ClinicService clinicService;

    public GetByNameHandler(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    public ResponseEntity<?> handle(String officialName) {
        return ResponseEntity.status(HttpStatus.OK).body(clinicService.getByName(officialName));
    }
}
