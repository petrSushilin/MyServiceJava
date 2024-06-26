package ru.medicaltickets.MyServiceJava.user.doctor.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.doctor.Doctor;
import ru.medicaltickets.MyServiceJava.user.doctor.DoctorService;

public class PostDoctorHandler {
    private final DoctorService doctorService;

    public PostDoctorHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public ResponseEntity<?> handle(Doctor doctor) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.post(doctor));
    }
}
