package ru.medicaltickets.MyServiceJava.user.doctor.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.global.exceptions.IdentifierMismatchException;
import ru.medicaltickets.MyServiceJava.user.doctor.Doctor;
import ru.medicaltickets.MyServiceJava.user.doctor.DoctorService;

public class UpdateDoctorHandler {
    private final DoctorService doctorService;

    public UpdateDoctorHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public ResponseEntity<?> handle(String doctorID, Doctor doctor) {
        Long parsedDoctorID = Long.valueOf(doctorID);
        if(!doctor.getID().equals(parsedDoctorID)) throw new IdentifierMismatchException("Attempt to throw a forbidden ID");
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.update(doctor));
    }
}
