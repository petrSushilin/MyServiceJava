package ru.medicaltickets.MyServiceJava.user.doctor.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.doctor.DoctorService;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;

public class GetDoctorsSpecialtyHandler {
    private final DoctorService doctorService;

    public GetDoctorsSpecialtyHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public ResponseEntity<?> handle(String doctorSpecialty) {
        DoctorSpecialty parsedDoctorSpecialty = DoctorSpecialty.valueOf(doctorSpecialty);
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getBySpecialty(parsedDoctorSpecialty));
    }
}
