package ru.medicaltickets.MyServiceJava.user.doctor.handlers;

import ru.medicaltickets.MyServiceJava.user.doctor.DoctorService;

public class PostDoctorHandler {
    private final DoctorService doctorService;

    public PostDoctorHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
