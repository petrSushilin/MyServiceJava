package ru.medicaltickets.MyServiceJava.user.doctor.handlers;

import ru.medicaltickets.MyServiceJava.user.doctor.DoctorService;

public class GetAllDoctorsHandler {
    private final DoctorService doctorService;

    public GetAllDoctorsHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
