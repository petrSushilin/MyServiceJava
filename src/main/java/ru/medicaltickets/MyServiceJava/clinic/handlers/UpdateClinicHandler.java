package ru.medicaltickets.MyServiceJava.clinic.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.clinic.Clinic;
import ru.medicaltickets.MyServiceJava.clinic.ClinicService;
import ru.medicaltickets.MyServiceJava.global.exceptions.IdentifierMismatchException;

public class UpdateClinicHandler {
    private final ClinicService clinicService;

    public UpdateClinicHandler(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    public ResponseEntity<?> handle(String clinicID, Clinic clinic) {
        Long parsedClinicID = Long.parseLong(clinicID);
        if (!parsedClinicID.equals(clinic.ID())) throw new IdentifierMismatchException("Attempt to throw a forbidden ID");
        return ResponseEntity.status(HttpStatus.OK).body(clinicService.update(clinic));
    }
}
