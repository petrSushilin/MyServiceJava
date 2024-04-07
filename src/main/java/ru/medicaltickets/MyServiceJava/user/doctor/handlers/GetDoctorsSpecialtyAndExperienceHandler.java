package ru.medicaltickets.MyServiceJava.user.doctor.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.doctor.DoctorService;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;

public class GetDoctorsSpecialtyAndExperienceHandler {
    private final DoctorService doctorService;

    public GetDoctorsSpecialtyAndExperienceHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public ResponseEntity<?> handle(String doctorSpecialty, String experience) {
        DoctorSpecialty parsedDoctorSpecialty = DoctorSpecialty.valueOf(doctorSpecialty);
        int parsedExperience = Integer.parseInt(experience);
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getBySpecialty(parsedDoctorSpecialty,
                                                                                                    parsedExperience));
    }
}
