package ru.medicaltickets.MyServiceJava.user.doctor.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.doctor.DoctorService;

public class GetDoctorsFullNameHandler {
    private final DoctorService doctorService;

    public GetDoctorsFullNameHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public ResponseEntity<?> handle(String firstName, String lastName) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getByFullName(firstName + " " + lastName));
    }
}
