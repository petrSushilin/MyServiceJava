package ru.medicaltickets.MyServiceJava.clinic.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.clinic.Clinic;
import ru.medicaltickets.MyServiceJava.clinic.ClinicService;

public class PostClinicHandler {
    private final ClinicService clinicService;

    public PostClinicHandler(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    public ResponseEntity<?> handle(Clinic clinic) {
        return ResponseEntity.status(HttpStatus.OK).body(clinicService.post(clinic));
    }
}
