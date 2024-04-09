package ru.medicaltickets.MyServiceJava.clinic.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.clinic.ClinicService;

public class GetSingleHandler {
    private final ClinicService clinicService;

    public GetSingleHandler(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    public ResponseEntity<?> handle(String clinicID) {
        Long parsedClinicID = Long.parseLong(clinicID);
        return ResponseEntity.status(HttpStatus.OK).body(clinicService.getSingle(parsedClinicID));
    }
}
