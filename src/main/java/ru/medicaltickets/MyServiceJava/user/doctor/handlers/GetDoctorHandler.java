package ru.medicaltickets.MyServiceJava.user.doctor.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.doctor.DoctorService;

public class GetDoctorHandler {
    private final DoctorService doctorService;

    public GetDoctorHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public ResponseEntity<?> handle(String doctorID) {
        Long parsedDoctorID = Long.valueOf(doctorID);
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getSingle(parsedDoctorID));
    }
}
