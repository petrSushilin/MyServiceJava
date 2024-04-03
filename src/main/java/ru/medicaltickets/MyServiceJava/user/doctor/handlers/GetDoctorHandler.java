package ru.medicaltickets.MyServiceJava.user.doctor.handlers;

import ru.medicaltickets.MyServiceJava.user.doctor.DoctorService;

public class GetDoctorHandler {
    private final DoctorService doctorService;

    public GetDoctorHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
